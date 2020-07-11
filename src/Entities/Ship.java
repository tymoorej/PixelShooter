package Entities;

import ImageHelpers.ImageHelper;
import Motion.Angle;
import Motion.Position;

import java.awt.image.BufferedImage;

public class Ship {
    private Position position;
    private BufferedImage image;
    private Angle angle;
    private static final int width = 100;
    private static final int height = 100;


    public Ship(Position position) {
        this.position = position;
        this.angle = new Angle(0);
        this.image = ImageHelper.loadImage(angle.getAngle());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void rotateLeft() {
        angle.rotateLeft();
        image = ImageHelper.loadImage(angle.getAngle());
    }

    public void rotateRight() {
        angle.rotateRight();
        image = ImageHelper.loadImage(angle.getAngle());
    }

    public BufferedImage getImage() {
        return image;
    }

    public Angle getAngle() {
        return angle;
    }

    public void setAngle(Angle angle) {
        this.angle = angle;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void increaseAcceleration() {
        position.getVelocity().getAcceleration().increaseYAcceleration();
    }

    public void decreaseAcceleration() {
        position.getVelocity().getAcceleration().decreaseYAcceleration();
    }

    public void updatePosition(){
        position.updatePosition(width, height);
    }
}
