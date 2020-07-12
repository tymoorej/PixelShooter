package Entities;

import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

public class MediumAsteroid extends Asteroid {

    private Position position;
    private Angle angle;

    public MediumAsteroid(int x, int y, int angle) {
        this.position = new Position(x, y,
                new Velocity(getVelocity(), getMaxVelocity(), getMinVelocity(),
                        getAcceleration(), shouldAdjustForFriction()));
        this.angle = new Angle(angle);
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
        return 50;
    }

    @Override
    public int getHeight() {
        return 50;
    }

    @Override
    public double getMaxVelocity() {
        return 5;
    }
}
