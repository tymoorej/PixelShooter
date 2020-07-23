package Entities;

import BoardHelpers.Board;
import Motion.Acceleration;
import Motion.Angle;
import Motion.Position;

import java.awt.image.BufferedImage;

public abstract class PhysicalEntity {
    public abstract Position getPosition();
    public abstract BufferedImage getImage();

    public abstract Angle getAngle();


    public int getCollisionWidth(){
        return getWidth();
    }
    public int getCollisionHeight(){
        return getHeight();
    }

    public abstract int getWidth();
    public abstract int getHeight();

    public abstract double getMaxVelocity();
    public abstract double getMinVelocity();
    public abstract double getVelocity();

    public abstract double getPositiveAccelerationIncrement();
    public abstract double getNegativeAccelerationIncrement();

    public abstract double getMaxAcceleration();
    public abstract double getMinAcceleration();

    public abstract Acceleration getAcceleration();

    public abstract int getMaxAngleRotation();

    public abstract boolean shouldAdjustForFriction();
    public abstract boolean shouldDeleteWhenOffScreen();

    public void updatePosition(){
        getPosition().updatePosition(getWidth(), getHeight(), getAngle().getAngle());
    }

    public void increaseAcceleration() {
        getPosition().getVelocity().getAcceleration().increaseAcceleration();
    }

    public void decreaseAcceleration() {
        getPosition().getVelocity().getAcceleration().decreaseAcceleration();
    }

    public void handleCollision(PhysicalEntity entity){
        if (entity instanceof Ship){
            handleCollision((Ship) entity);
        }
        if (entity instanceof Laser){
            handleCollision((Laser) entity);
        }
        if (entity instanceof Asteroid){
            handleCollision((Asteroid) entity);
        }
    }

    public abstract void handleCollision(Ship ship);
    public abstract void handleCollision(Laser laser);
    public abstract void handleCollision(Asteroid asteroid);

    public void delete(){
        Board.getInstance().RemoveEntity(this);
    }
}
