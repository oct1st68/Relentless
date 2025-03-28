package entities;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import main.GamePanel;
import Input.KeyboardInput;

import javax.imageio.ImageIO;



public class Player extends entities {
    GamePanel gp;
    KeyboardInput keyboardInput;
    private int health;
    private String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;



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
        if(keyboardInput.upPressed || keyboardInput.downPressed || keyboardInput.leftPressed || keyboardInput.rightPressed) {
            if (keyboardInput.upPressed) {
                direction = "up";
                y -= speed;
            } else if (keyboardInput.downPressed) {
                direction = "down";
                y += speed;
            } else if (keyboardInput.leftPressed) {
                direction = "left";
                x -= speed;
            } else if (keyboardInput.rightPressed) {
                direction = "right";
                x += speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;

                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;

                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;

                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
            }
            g2.drawImage(image, x, y, gp.TitleSize, gp.TitleSize, null);
        }
    }




