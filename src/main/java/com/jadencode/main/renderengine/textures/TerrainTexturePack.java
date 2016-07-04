package com.jadencode.main.renderengine.textures;

/**
 * Created by gtrpl on 7/4/2016.
 */
public class TerrainTexturePack {

    public final TerrainTexture backgroundTexture;
    public final TerrainTexture rTexture;
    public final TerrainTexture gTexture;
    public final TerrainTexture bTexture;

    public TerrainTexturePack(TerrainTexture backgroundTexture, TerrainTexture rTexture, TerrainTexture gTexture, TerrainTexture bTexture) {
        this.backgroundTexture = backgroundTexture;
        this.rTexture = rTexture;
        this.gTexture = gTexture;
        this.bTexture = bTexture;
    }

}