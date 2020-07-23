package Entities;

import BoardHelpers.Board;
import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

public class MediumAsteroid extends Asteroid {

    private Position position;
    private Angle angle;

    public MediumAsteroid(double x, double y, int angle) {
        super();
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

    @Override
    public void handleCollision(Laser laser) {
        if (!Board.getInstance().containsInDeleteQueue(this)) {
            Board.getInstance().addToDeleteQueue(this);

            SmallAsteroid smallAsteroid1 = new SmallAsteroid(position.getX(), position.getY(), (int) (Math.random() * (360)));
            SmallAsteroid smallAsteroid2 = new SmallAsteroid(position.getX(), position.getY(), (int) (Math.random() * (360)));

            Board.getInstance().addEntityToQueue(smallAsteroid1);
            Board.getInstance().addEntityToQueue(smallAsteroid2);
        }
    }

}
