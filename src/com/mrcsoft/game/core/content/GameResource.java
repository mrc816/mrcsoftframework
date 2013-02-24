package com.mrcsoft.game.core.content;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class GameResource<T> {

    private T gameObject;


    public GameResource(T gameObject)
    {
        this.gameObject = gameObject;
    }

    public T getValue()
    {
        return  gameObject;
    }

    public boolean  isImage()
    {
        return gameObject instanceof Image;
    }

 }
