package Entities;

import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

public class SmallAsteroid extends Asteroid {
    private Position position;
    private Angle angle;

    public SmallAsteroid(int x, int y, int angle) {
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
    public Angle getAngle() {
        return angle;
    }

    @Override
    public int getWidth() {
        return 20;
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    public double getMaxVelocity() {
        return 10;
    }

}
