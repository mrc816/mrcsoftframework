package com.mrcsoft.game.core;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 20:54
 * To change this template use File | Settings | File Templates.
 */
public abstract class Utils {


    public  static final String NoExtension = "";

    public static String getFileExtension(File file)
    {
        return getFileExtension(file.getName());
    }

    public static String getFileExtension(String name) {

        final int l_index =  name.lastIndexOf(".");
        return  l_index < 0 ? NoExtension : name.substring(l_index);
    }


}
