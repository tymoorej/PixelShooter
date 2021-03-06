package Entities;

import ImageHelpers.ImageHelper;
import Motion.Acceleration;
import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

import java.awt.image.BufferedImage;

public class Laser extends PhysicalEntity{
    private Position position;
    private Angle angle;
    private static int totalLasers;
    public static final int MAX_LASERS = 3;

    public Laser(double x, double y, int angle) {
        totalLasers ++;
        this.position = new Position(x, y,
                new Velocity(getVelocity(), getMaxVelocity(), getMinVelocity(),
                        getAcceleration(), shouldAdjustForFriction()), shouldDeleteWhenOffScreen(), this);
        this.angle = new Angle(angle, getMaxAngleRotation());
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public BufferedImage getImage() {
        return ImageHelper.loadImage("laser");
    }

    @Override
    public Angle getAngle() {
        return angle;
    }

    @Override
    public int getWidth() {
        return 35;
    }

    @Override
    public int getHeight() {
        return 25;
    }

    @Override
    public double getMaxVelocity() {
        return 10;
    }

    @Override
    public double getMinVelocity() {
        return 50;
    }

    @Override
    public double getVelocity() {
        return 50;
    }

    @Override
    public double getPositiveAccelerationIncrement() {
        return 0;
    }

    @Override
    public double getNegativeAccelerationIncrement() {
        return 0;
    }

    @Override
    public double getMaxAcceleration() {
        return 0;
    }

    @Override
    public double getMinAcceleration() {
        return 0;
    }

    @Override
    public int getMaxAngleRotation() {
        return 0;
    }

    @Override
    public boolean shouldAdjustForFriction() {
        return false;
    }

    @Override
    public boolean shouldDeleteWhenOffScreen() {
        return true;
    }

    public Acceleration getAcceleration(){
        return new Acceleration(0, getPositiveAccelerationIncrement(),
                getNegativeAccelerationIncrement(), getMaxAcceleration(),
                getMinAcceleration());
    }

    @Override
    public void handleCollision(Ship ship) {}

    @Override
    public void handleCollision(Laser laser) {}

    @Override
    public void handleCollision(Asteroid asteroid) {}

    @Override
    public void delete() {
        super.delete();
        totalLasers --;
    }

    public static int getTotalLasers() {
        return totalLasers;
    }

    @Override
    public int getCollisionWidth() {
        return getWidth() * 2;
    }

    @Override
    public int getCollisionHeight() {
        return getHeight() * 2;
    }
}
