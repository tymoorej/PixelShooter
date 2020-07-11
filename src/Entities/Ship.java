package Entities;

import BoardHelpers.Board;
import BoardHelpers.Location;
import ImageHelpers.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ship {
    private Location location;
    private BufferedImage image;
    private int angle;
    private int width;
    private int height;

    public Ship(Location location) {
        this.location = location;
        location.setHasPlayer(true);
        this.angle = 0;
        this.image = ImageHelper.loadImage(angle);
        this.width = 100;
        this.height = 100;

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void moveUp() {
        location.setHasPlayer(false);
        location = Board.getInstance().getLocation(location.getX(), location.getY() - 1);
        location.setHasPlayer(true);
    }

    public void moveDown() {
        location.setHasPlayer(false);
        location = Board.getInstance().getLocation(location.getX(), location.getY() + 1);
        location.setHasPlayer(true);
    }

    public void rotateLeft() {
        angle = angle - 10;
        if (angle < 0){
            angle = 350;
        }
        image = ImageHelper.loadImage(angle);
    }

    public void rotateRight() {
        angle = angle + 10;
        if (angle > 360){
            angle = 10;
        }
        image = ImageHelper.loadImage(angle);
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
