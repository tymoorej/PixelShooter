package Entities;

import ImageHelpers.ImageHelper;
import Motion.Acceleration;
import Motion.Velocity;

import java.awt.image.BufferedImage;

public abstract class Asteroid extends PhysicalEntity{

    private static int totalAsteroids = 0;

    public Asteroid() {
        totalAsteroids++;
    }

    @Override
    public boolean shouldAdjustForFriction() {
        return false;
    }

    @Override
    public BufferedImage getImage() {
        return ImageHelper.loadImage("asteroid");
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
    public double getMinVelocity() {
        return 0;
    }

    public Acceleration getAcceleration(){
        return new Acceleration(0, getPositiveAccelerationIncrement(),
                getNegativeAccelerationIncrement(), getMaxAcceleration(),
                getMinAcceleration());
    }

    public double getVelocity(){
        return getMaxVelocity();
    }

    @Override
    public int getMaxAngleRotation() {
        return 0;
    }

    @Override
    public boolean shouldDeleteWhenOffScreen() {
        return false;
    }

    @Override
    public void handleCollision(Ship ship) {}

    @Override
    public void handleCollision(Asteroid asteroid) {}

    public static int getTotalAsteroids() {
        return totalAsteroids;
    }

    @Override
    public void delete() {
        super.delete();
        totalAsteroids--;
    }
}
