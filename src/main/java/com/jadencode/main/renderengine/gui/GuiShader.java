package com.jadencode.main.renderengine.gui;

import com.jadencode.main.renderengine.ShaderProgram;
import com.jadencode.main.renderengine.toolbox.ShaderUniform;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by gtrpl on 7/5/2016.
 */
public class GuiShader extends ShaderProgram {
    private static final String VERTEX_FILE = "shaders/guiVertexShader.glsl";
    private static final String FRAGMET_FILE = "shaders/guiFragmentShader.glsl";

    public final ShaderUniform<Matrix4f> TRANSFORMATION_MATRIX = new ShaderUniform<>("transformationMatrix", this, (i, v) -> this.load(i, v));

    public GuiShader() {
        super(VERTEX_FILE, FRAGMET_FILE);
    }
//    public void loadTransformation(Matrix4f matrix) {
//        this.loadMatrix(TRANSFORMATION_MATRIX, matrix);
//    }
    @Override
    protected void getAllUniformLocations() {
//        this.bindLocation(TRANSFORMATION_MATRIX);
    }
    @Override
    public void bindAttributes() {
        this.bindAttribute(0, "position");
    }
}
