#version 400 core

in vec2 passTextureCoords;
in vec3 surfaceNormal;
in vec3 toLightVector[4];
in vec3 toCameraVector;
in float visibility;

out vec4 outColor;

uniform sampler2D textureSampler;
uniform vec3 lightColor[4];
uniform vec3 attenuation[4];
uniform float shineDamper;
uniform float reflectivity;
uniform vec3 skyColor;

void main(void) {
    vec3 unitNormal = normalize(surfaceNormal);
    vec3 unitCamera = normalize(toCameraVector);

    vec3 totalDiffuse = vec3(0.0);
    vec3 totalSpecular = vec3(0.0);

    for(int i = 0; i < 4; i++) {
       float distance = length(toLightVector[i]);
       float attFactor = attenuation[i].x + attenuation[i].y * distance + attenuation[i].z * distance * distance;
       vec3 unitLight = normalize(toLightVector[i]);
       float nDot1 = dot(unitNormal, unitLight);
       float brightness = max(nDot1, 0.0);
       vec3 lightDirection = -unitLight;
       vec3 reflectedLight = reflect(lightDirection, unitNormal);
       float specularFactor = dot(reflectedLight, unitCamera);
       specularFactor = max(specularFactor, 0.0);
       float dampedFactor = pow(specularFactor, shineDamper);
       totalDiffuse = totalDiffuse + (brightness * lightColor[i]) / attFactor;
       totalSpecular = totalSpecular + (dampedFactor * reflectivity * lightColor[i]) / attFactor;
    }
    totalDiffuse = max(totalDiffuse, 0.2);

    vec4 textureColor = texture(textureSampler, passTextureCoords);
    if(textureColor.a < 0.5) {
        discard;
    }

    outColor = vec4(totalSpecular, 1.0) + vec4(totalDiffuse, 1.0) * texture(textureSampler, passTextureCoords);
    outColor = mix(vec4(skyColor, 1.0), outColor, visibility);
}