package com.mrcsoft.game.core;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class SceneManager {

    private  Scene currentScene;

    public void attachScene(Scene scene)
    {
        if (scene == null)
            return;

      if (currentScene != null &&  currentScene.getSceneListner() != null)
      {
          currentScene.getSceneListner().onDetach();
      }

        currentScene = scene;

        if (currentScene != null &&  currentScene.getSceneListner() != null)
        {
            currentScene.getSceneListner().onAttach();
        }
    }


    public void update(long time)
    {
        if(currentScene!=null)
            currentScene.update(time);
    }

    public void render()
    {
        if(currentScene!=null)
            currentScene.render();
    }









}
