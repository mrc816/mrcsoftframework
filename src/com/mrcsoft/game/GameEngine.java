package com.mrcsoft.game;

import com.mrcsoft.game.core.SceneManager;
import com.mrcsoft.game.core.Surface;
import com.mrcsoft.game.core.content.ContentManager;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class GameEngine {


    private Frame frame;
    private Graphics graphics;
    private GameLooper looper;
    private Surface gameSurface;
    private ContentManager contentManager;
    private SceneManager sceneManager;

    private GameEngine(Frame frame) {
        this.frame = frame;
        initialization();

    }

    private void initialization() {
        graphics = frame.getGraphics();
        sceneManager = new SceneManager();
        gameSurface = new Surface(frame.getWidth(), frame.getHeight(), graphics);
        looper = new GameLooper();
        looper.start();
    }


    private static GameEngine instance;

    public static GameEngine getInstance() {
        return instance;
    }

    public static void Create(Frame awtFrame) {
        instance = new GameEngine(awtFrame);
    }

    public GameLooper getLooper() {
        return looper;
    }

    public Frame getFrame() {
        return frame;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public SceneManager getSceneManager()
    {
        return  sceneManager;
    }

    public ContentManager getContentManager()
    {
        return  contentManager;
    }


    public void update(long frameTime) {



    }


    public void render() {

        gameSurface.clear(Color.blue);

        gameSurface.render();
    }
}
