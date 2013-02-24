import com.mrcsoft.game.GameEngine;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created with IntelliJ IDEA.
 * User: Marek
 * Date: 23.02.13
 * Time: 23:12
 * Moje przykladowe okienko
  */
public class GameWindow extends Frame implements WindowListener{

    public final static int WindowWidth = 1024;
    public final static int WindowHeight = 768;

    public GameWindow()
    {
        addWindowListener(this);

        //setBounds(0,0, 1024,768);
        setSize(WindowWidth,WindowHeight);
        setVisible(true);

        GameEngine.Create(this);


    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
        try {
            GameEngine.getInstance().getLooper().stop();
        } catch (InterruptedException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
