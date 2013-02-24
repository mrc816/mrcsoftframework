package com.mrcsoft.game.core.content;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public abstract class StaticResourceLoader {

    public static final String ExtensionJPG1 = ".jpg";
    public static final String ExtensionJPG2 = ".jpeg";
    public static final String ExtensionPNG = ".png";
    public static final String ExtensionGIF = ".gif";

    public static class  ImageLoader implements GameResourceLoader
    {

        @Override
        public GameResource load(String fileName) {
               return  load(new File(fileName));
        }

        @Override
        public GameResource load(File f) {
            try
            {
                final BufferedImage result = ImageIO.read(f);
                final GameResource<Image> resource = new GameResource<Image>(result);
                return resource;
            }
            catch (IOException e)
            {
                return  null;
            }
        }
    }


}


