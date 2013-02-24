package com.mrcsoft.game.core.content;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 21:12
 * To change this template use File | Settings | File Templates.
 */
public interface GameResourceLoader {
    public GameResource load(String fileName);
    public GameResource load(File f);
}
