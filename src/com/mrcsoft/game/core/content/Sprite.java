package com.mrcsoft.game.core.content;

import com.mrcsoft.game.GameEngine;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 19:50
 * To change this template use File | Settings | File Templates.
 */
public abstract class Sprite {

    protected  int width;
    protected  int height;
    protected Image image;

    public  Sprite(int width,int height,String imageName)
    {
        this.width = width;
        this.height = height;

        this.image = GameEngine.getInstance().getContentManager().getImage(imageName);

    }



}
