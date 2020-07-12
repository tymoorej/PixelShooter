package Entities;

import ImageHelpers.ImageHelper;
import Motion.Acceleration;
import Motion.Velocity;

import java.awt.image.BufferedImage;

public abstract class Asteroid extends PhysicalEntity{
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
}
