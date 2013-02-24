package com.mrcsoft.game.core;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public abstract  class Entity {

    protected  int x;
    protected  int y;
    protected  Surface surface;


    public Entity()
    {

    }
    public abstract  void update(long time);
    public abstract  void render();

}
