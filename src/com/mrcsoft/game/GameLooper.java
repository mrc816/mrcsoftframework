package com.mrcsoft.game;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 24.02.13
 * Time: 17:15
 * Obsługa głównej pętli
 */
public final class GameLooper implements  Runnable {


    private  float fps;
    private  long totalTime;
    private  long frameTime;
    private  long startTime;
    private  boolean  running;
    private  Thread looperThread;

    public float getFps()
    {
        return fps;
    }

    public long getTotalTime()
    {
        return totalTime;
    }

    public GameLooper()
    {
        totalTime = frameTime = 0;
        startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {

        startTime = System.currentTimeMillis();

        while (running)
        {
             frameTime = (System.currentTimeMillis() - startTime) - totalTime;
             totalTime+=frameTime;

             GameEngine.getInstance().update(frameTime);
             GameEngine.getInstance().render();
        }

    }


    public void start() {

        if (looperThread!=null  )
        {
             return;
        }

        running = true;

        looperThread = new Thread(this);
        //lets run "run" method from GameLooper class
        looperThread.start();




    }


    public void stop() throws InterruptedException {

            running = false;

             if (looperThread!=null && looperThread.isAlive())
                 looperThread.join(5000);


    }
}

