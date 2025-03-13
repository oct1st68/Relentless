package main;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable {
    final int originalTitleSize = 16;
    final int scale = 3;

    final int TitleSize = originalTitleSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int ScreenWidth = maxScreenCol * TitleSize;
    final int ScreenHeight = maxScreenRow * TitleSize;
    Thread GameThread;
    public GamePanel(int width, int height){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    public void StartGameThread{
        GameThread = new Thread(this);
        GameThread.start();
    }

    @Override
    public void run(){

    }
}
