package Entities;

import ImageHelpers.ImageHelper;
import Motion.Acceleration;
import Motion.Angle;
import Motion.Position;
import Motion.Velocity;
import UI.Screen;

import java.awt.image.BufferedImage;

public class Ship extends PhysicalEntity{
    private Position position;
    private BufferedImage image;
    private Angle angle;

    public Ship() {
        this.position = new Position(
                Screen.getInstance().getMiddleX(),
                Screen.getInstance().getMiddleY(),
                new Velocity(0, getMaxVelocity(), getMinVelocity(),
                        new Acceleration(0, getPositiveAccelerationIncrement(),
                                getNegativeAccelerationIncrement(), getMaxAcceleration(), getMinAcceleration()),
                        shouldAdjustForFriction())
        );
        this.angle = new Angle(0);
        this.image = ImageHelper.loadImage(String.valueOf(angle.getAngle()));
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void rotateLeft() {
        angle.rotateLeft();
        image = ImageHelper.loadImage(String.valueOf(angle.getAngle()));
    }

    public void rotateRight() {
        angle.rotateRight();
        image = ImageHelper.loadImage(String.valueOf(angle.getAngle()));
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

    public void increaseAcceleration() {
        position.getVelocity().getAcceleration().increaseAcceleration();
    }

    public void decreaseAcceleration() {
        position.getVelocity().getAcceleration().decreaseAcceleration();
    }

    public void updatePosition(){
        position.updatePosition(getWidth(), getHeight(), angle.getAngle());
    }

    @Override
    public int getWidth() {
        return 100;
    }

    @Override
    public int getHeight() {
        return 100;
    }

    @Override
    public double getMaxVelocity() {
        return 50;
    }

    @Override
    public double getMinVelocity() {
        return -2;
    }

    @Override
    public double getPositiveAccelerationIncrement() {
        return 0.1;
    }

    @Override
    public double getNegativeAccelerationIncrement() {
        return 0.5;
    }

    @Override
    public double getMaxAcceleration() {
        return 2;
    }

    @Override
    public double getMinAcceleration() {
        return 0;
    }

    @Override
    public boolean shouldAdjustForFriction() {
        return true;
    }

}
