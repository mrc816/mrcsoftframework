package com.mrcsoft.game.core;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public abstract  class Scene {

    private SceneListner sceneListner;

    public void setSceneListner(SceneListner sceneListner)
    {
        this.sceneListner = sceneListner;
    }

    public SceneListner getSceneListner()
    {
        return sceneListner;
    }

    public void update(long time)
    {

    }

    public void render()
    {

    }









}
