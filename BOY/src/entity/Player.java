package entity;

import main.GamePanel;
import main.KeyHandler;
import proxyImage.ProxyImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp= gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }
    public void getPlayerImage() {
        up1 = new ProxyImage("/res/player/boy_up_0.png");
        up2 = new ProxyImage("/res/player/boy_up_1.png");
        // up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_3.png"));
        down1 = new ProxyImage("/res/player/boy_down_0.png");
        down2 = new ProxyImage("/res/player/boy_down_1.png");
        left1 = new ProxyImage("/res/player/boy_left_0.png");
        left2 = new ProxyImage("/res/player/boy_left_1.png");
        right1 = new ProxyImage("/res/player/boy_right_0.png");
        right2 = new ProxyImage("/res/player/boy_right_1.png");


    }

    public void update(){
        if(keyH.upPressed == true){
            direction = "up";
            y-= speed;
        }
        else if (keyH.downPressed == true){
            direction = "down";
            y += speed;
        }
        else if (keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }
        else if (keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if (spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
    //    g2.setColor(Color.white);
   //     g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        Image image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1) {
                    image = up1.loadImage().getImage();
                }
                if (spriteNum == 2) {
                    image = up2.loadImage().getImage();
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1.loadImage().getImage();
                }
                if (spriteNum == 2) {
                    image = down2.loadImage().getImage();
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image=left1.loadImage().getImage();
                }
                if (spriteNum == 2) {
                    image=left2.loadImage().getImage();
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image=right1.loadImage().getImage();
                }
                if (spriteNum == 2) {
                    image=right2.loadImage().getImage();
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
