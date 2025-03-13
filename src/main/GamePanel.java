package main;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable {
    //Draw Screen
    KeyIput.KeyboardInput keyboardInput = new KeyIput.KeyboardInput();
    final int originalTitleSize = 16;
    final int scale = 3;
    final int TitleSize = originalTitleSize * scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 16;
    final int ScreenWidth = maxScreenCol * TitleSize;
    final int ScreenHeight = maxScreenRow * TitleSize;

    //FPS
    int FPS = 60;

    public GamePanel(int width, int height){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
        addKeyListener(keyboardInput);
        this.setFocusable(true);
    }

    Thread GameThread;
    public void StartGameThread(){
        GameThread = new Thread(this);
        GameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000.0 / FPS; // Time per frame in nanoseconds
        long lastTime = System.nanoTime();
        long timer = 0;
        int frameCount = 0;

        while (GameThread != null) {
            long currentTime = System.nanoTime();
            double deltaTime = (currentTime - lastTime) / drawInterval;

            // Calculate timer before updating lastTime
            timer += currentTime - lastTime;
            lastTime = currentTime;

            // Update game logic
            update();

            // Repaint graphics
            repaint();

            // Ensure consistent FPS
            long sleepTime = (long) ((drawInterval - (System.nanoTime() - lastTime)) / 1_000_000); // Convert to milliseconds

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Debug: Count frames per second
            frameCount++;
            if (timer >= 1_000_000_000) {
                System.out.println("FPS: " + frameCount);
                frameCount = 0;
                timer = 0;
            }
        }
    }

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    public void update(){
        if(keyboardInput.upPressed){
            playerY -= playerSpeed;
        }
        else if(keyboardInput.downPressed){
            playerY += playerSpeed;
        }
        else if(keyboardInput.leftPressed){
            playerX -= playerSpeed;
        }
        else if(keyboardInput.rightPressed){
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(playerX,playerY,TitleSize,TitleSize);
        g2d.dispose(); //dispose of graphics context and release
    }
}
