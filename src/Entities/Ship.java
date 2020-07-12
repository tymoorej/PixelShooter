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
        this.angle = new Angle(0, getMaxAngleRotation());
    }

    public void rotateLeft() {
        angle.rotateLeft();
    }

    public void rotateRight() {
        angle.rotateRight();
    }

    public Position getPosition() {
        return position;
    }

    public BufferedImage getImage() {
        int diffFromFive = angle.getAngle() % 5;
        int angleToNearestFive = angle.getAngle() - diffFromFive;
        if (diffFromFive >=3){
            angleToNearestFive += 5;
        }
        return ImageHelper.loadImage(String.valueOf(angleToNearestFive));
    }

    public Angle getAngle() {
        return angle;
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
        return 20;
    }

    @Override
    public double getMinVelocity() {
        return -2;
    }

    @Override
    public double getPositiveAccelerationIncrement() {
        return 0.01;
    }

    @Override
    public double getNegativeAccelerationIncrement() {
        return 0.025;
    }

    @Override
    public double getMaxAcceleration() {
        return 0.8;
    }

    @Override
    public double getMinAcceleration() {
        return -2;
    }

    @Override
    public boolean shouldAdjustForFriction() {
        return true;
    }

    @Override
    public int getMaxAngleRotation() {
        return 5;
    }
}
