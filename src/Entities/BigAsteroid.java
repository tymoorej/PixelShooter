package Entities;

import BoardHelpers.Board;
import GameHelper.Game;
import Motion.Angle;
import Motion.Position;
import Motion.Velocity;

public class BigAsteroid extends Asteroid {

    private Position position;
    private Angle angle;

    public BigAsteroid(double x, double y, int angle) {
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

    @Override
    public void handleCollision(Laser laser) {
        if (!Board.getInstance().containsInDeleteQueue(this)){
            Board.getInstance().addToDeleteQueue(this);

            MediumAsteroid mediumAsteroid1 = new MediumAsteroid(position.getX(), position.getY(), (int) (Math.random() * (360)));
            MediumAsteroid mediumAsteroid2 = new MediumAsteroid(position.getX(), position.getY(), (int) (Math.random() * (360)));
            Board.getInstance().addEntityToQueue(mediumAsteroid1);
            Board.getInstance().addEntityToQueue(mediumAsteroid2);
        }
    }
}
