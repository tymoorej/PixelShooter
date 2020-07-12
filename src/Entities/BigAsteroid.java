package Entities;

import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

public class BigAsteroid extends Asteroid {

    private Position position;
    private Angle angle;

    public BigAsteroid(int x, int y, int angle) {
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
        return 100;
    }

    @Override
    public int getHeight() {
        return 100;
    }

    @Override
    public double getMaxVelocity() {
        return 2;
    }
}
