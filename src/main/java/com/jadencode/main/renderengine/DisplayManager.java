package com.jadencode.main.renderengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;

/**
 * Created by gtrpl on 7/1/2016.
 */
public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 120;

    private final int width;
    private final int height;
    private final int fpsSync;

    private static long lastFrameTime;
    private static long lastFrameRenderTime;

    public DisplayManager(int w, int h, int f) {
        this.width = w;
        this.height = h;
        this.fpsSync = f;
        this.create();
    }

    public DisplayManager() {
        this(WIDTH, HEIGHT, FPS_CAP);
    }

    public boolean isCloseRequested() {
        return Display.isCloseRequested();
    }

    public void create() {
        ContextAttribs attribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true);
        try {
            Display.setDisplayMode(new DisplayMode(this.width, this.height));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("3D Item View");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glViewport(0, 0, this.width, this.height);
    }

    public void update() {
        Display.sync(this.fpsSync);
        Display.update();
        long currentFrameTime = getCurrentTime();
        lastFrameRenderTime = (currentFrameTime - lastFrameTime);
        lastFrameTime = currentFrameTime;
    }
    
    public static long getRenderMs() {
        return lastFrameRenderTime;
    }

    public void destroy() {
        Display.destroy();
    }

    private static long getCurrentTime() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
}