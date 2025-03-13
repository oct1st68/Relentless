package entities;
import java.awt.Image;
import java.awt.Toolkit;

public class Player {
    private int health;
    private double x,y;
    private int speed;
    private String direction;
    private Image sprite;

    public Player(double StartX, double StartY){
        this.x = StartX;
        this.y = StartY;
        this.health = 100;
        this.speed = 2;
        this.direction = "down";

    }



}
