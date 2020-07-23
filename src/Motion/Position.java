package Motion;

import BoardHelpers.Board;
import Entities.PhysicalEntity;
import UI.Screen;

import java.util.concurrent.Semaphore;

public class Position {
    private double x;
    private double y;
    private Velocity velocity;
    private boolean deleteWhenOffScreen;
    private PhysicalEntity parent;

    public Position(double x, double y, Velocity velocity, boolean deleteWhenOffScreen, PhysicalEntity parent) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.deleteWhenOffScreen = deleteWhenOffScreen;
        this.parent = parent;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public void updatePosition(int width, int height, int angle){
        velocity.updateVelocity();

        double xVelocity = velocity.getVelocity() * Math.sin(Math.toRadians(angle));
        double yVelocity = velocity.getVelocity() * Math.cos(Math.toRadians(angle));

        updateXPosition(width, xVelocity);
        updateYPosition(height, yVelocity);
    }

    private void updateXPosition(int width, double velocity){
        x = x + velocity;
        if (x > Screen.getInstance().getWidth() - width){
            if (deleteWhenOffScreen){
                Board.getInstance().addToDeleteQueue(parent);
                return;
            }
            x = 0;
        }
        else if (x < 0){
            x = Screen.getInstance().getWidth() - width;
            if (deleteWhenOffScreen){
                Board.getInstance().addToDeleteQueue(parent);
                return;
            }
        }
    }

    private void updateYPosition(int height, double velocity){
        y = y - velocity;
        if (y > Screen.getInstance().getHeight() - height){
            if (deleteWhenOffScreen){
                Board.getInstance().addToDeleteQueue(parent);
                return;
            }
            y = 0;
        }
        else if (y < 0){
            if (deleteWhenOffScreen){
                Board.getInstance().addToDeleteQueue(parent);
                return;
            }
            y = Screen.getInstance().getHeight() - height;
        }
    }

}
