package com.mrcsoft.game.core.content;

import com.mrcsoft.game.core.Utils;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class ContentManager {



    private Map<String,GameResource> container;
    private Map<String,Class<?>> loaders;


     public ContentManager()
     {
            container = new HashMap<String, GameResource>();
             initLoaders();

     }

    private void initLoaders() {
        lastLoader = null;
        lastLoaderClass = null;

       loaders = new HashMap<String, Class<?>>();

       loaders.put(StaticResourceLoader.ExtensionJPG1, StaticResourceLoader.ImageLoader.class);
       loaders.put(StaticResourceLoader.ExtensionJPG2, StaticResourceLoader.ImageLoader.class);
       loaders.put(StaticResourceLoader.ExtensionPNG, StaticResourceLoader.ImageLoader.class);
       loaders.put(StaticResourceLoader.ExtensionGIF, StaticResourceLoader.ImageLoader.class);

    }


    public boolean loadFromDirectory(final String path,final String virtualName)
    {
        final File directory = new File(path);

        if(!directory.isDirectory())
            return false;

        boolean result  = true;
        for(File file : directory.listFiles() )
            result =  loadFromFile(file.getAbsolutePath(), null);

        return result;
    }

    private  GameResourceLoader lastLoader;
    private Class<?> lastLoaderClass;

    public boolean loadFromFile(final String path, String virtualName)
    {

        final File f = new File(path);
        if(!f.exists())
            return false;

        final String ext = Utils.getFileExtension(f);

        if(ext.equalsIgnoreCase(Utils.NoExtension))
            return  false;

        if(virtualName == null)
        {
            if(f.getName().length() == ext.length())
                return false;

            virtualName = f.getName().substring( 0 , f.getName().length()-ext.length());

        }


        final Class<?> clazz =   loaders.get(ext);

        if(clazz == null)
        {
            //todo: Zaloguj blad
            return  false;
        }

        if(!clazz.equals(lastLoaderClass))
        {
                try {
                    final Constructor<?> c = clazz.getConstructor(null);
                    lastLoader = (GameResourceLoader)c.newInstance(null) ;
                    lastLoaderClass = clazz;
                } catch (NoSuchMethodException e) {
                    return false;
                } catch (InvocationTargetException e) {
                    return false;
                } catch (InstantiationException e) {
                    return false;
                } catch (IllegalAccessException e) {
                    return false;
                }
        }


        final GameResource resource = lastLoader.load(f);
        if(resource == null)
            return false;

        container.put(virtualName, resource);

        return true;
    }


    public Image getImage(final String name)
    {
      final GameResource resource =  container.get(name);

        if(resource == null || resource.getValue() instanceof  Image )
            return   (Image)resource.getValue();

        return null;
    }




}
