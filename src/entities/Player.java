package entities;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

import main.GamePanel;
import Input.KeyboardInput;

import javax.imageio.ImageIO;


public class Player extends entities {
    GamePanel gp;
    KeyboardInput keyboardInput;
    private int health;
    private String direction;

    public Player(GamePanel gp, KeyboardInput keyboardInput){
        this.gp = gp;
        this.keyboardInput = keyboardInput;
        setDefaults();
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/boy_right_2.png")));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setDefaults(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
        health = 100;
    }

    public void update(){
        if(keyboardInput.upPressed){
            direction = "up";
            y -= speed;
        }
        else if(keyboardInput.downPressed){
            direction = "down";
            y += speed;
        }
        else if(keyboardInput.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if(keyboardInput.rightPressed){
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            }
            g2.drawImage(image, x, y, gp.TitleSize, gp.TitleSize, null);
        }
    }




