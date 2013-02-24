package com.mrcsoft.game.core;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class Surface {


    private BufferedImage image;
    private Graphics destGraphics;
    private Graphics2D sourceGraphics;
   // private  Paint clearPaint;


    public Surface(int width,int height, Graphics graphics)
    {
        this.destGraphics  =graphics;
        image =  new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        this.sourceGraphics = image.createGraphics();
    }

    public BufferedImage getImage()
    {
             return image;
    }

    public void render()
    {
         this.destGraphics.drawImage(image,0,0, image.getWidth(),image.getHeight(),null);
    }

    public  void clear(Color color)
    {
        this.sourceGraphics.setPaint(color);
        this.sourceGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    public void drawImage(int x, int y, Image image)
    {
        this.sourceGraphics.drawImage(image, )
    }


}
