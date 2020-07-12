package Entities;

import Motion.Angle;
import Motion.Position;

import java.awt.image.BufferedImage;

public class Boulder extends PhysicalEntity{

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public Angle getAngle() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public double getMaxVelocity() {
        return 0;
    }

    @Override
    public double getMinVelocity() {
        return 0;
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
    public boolean shouldAdjustForFriction() {
        return false;
    }
}
