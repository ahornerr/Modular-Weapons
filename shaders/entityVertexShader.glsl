#version 400 core

in vec3 position;
in vec2 textureCoords;
in vec3 normal;

out vec2 passTextureCoords;
out vec3 surfaceNormal;
out vec3 toLightVector[4];
out vec3 toCameraVector;
out float visibility;
out vec4 shadowCoords;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;
uniform vec3 lightPosition[4];

uniform mat4 toShadowMapSpace;

uniform int numberOfRows;
uniform vec2 offset;

uniform float useFakeLighting;
uniform float fogDensity;
uniform float fogGradient;

uniform vec4 clipPlane;

const float shadowDistance = 150.0;
const float transitionDistance = 10.0;

void main(void) {

    vec4 worldPosition = transformationMatrix * vec4(position, 1.0);

    shadowCoords = toShadowMapSpace * worldPosition;

    gl_ClipDistance[0] = dot(worldPosition, clipPlane);

    vec4 positionRelativeToCam = viewMatrix * worldPosition;
    gl_Position = projectionMatrix * positionRelativeToCam;
    passTextureCoords = (textureCoords / numberOfRows) + offset;

    vec3 actualNormal = normal;
    if(useFakeLighting > 0.5) {
        actualNormal = vec3(0.0, 1.0, 0.0);
    }

    surfaceNormal = (transformationMatrix * vec4(actualNormal, 0.0)).xyz;
    for(int i = 0; i < 4; i++) {
        toLightVector[i] = lightPosition[i] - worldPosition.xyz;
    }
    toCameraVector = (inverse(viewMatrix) * vec4(0.0, 0.0, 0.0, 1.0)).xyz - worldPosition.xyz;

    float distance = length(positionRelativeToCam.xyz);
    visibility = exp(-pow((distance * fogDensity), fogGradient));
    visibility = clamp(visibility, 0.0, 1.0);

    distance = distance - (shadowDistance - transitionDistance);
    distance = distance / transitionDistance;
    shadowCoords.w = clamp(1.0 - distance, 0.0, 1.0);
}



