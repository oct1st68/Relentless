package main;


import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    public static int width;
    public static int height;



    public GamePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }
}
