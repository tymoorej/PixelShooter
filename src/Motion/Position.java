package Motion;

import UI.Screen;

public class Position {
    private int x;
    private int y;
    private Velocity velocity;

    public Position(int x, int y, Velocity velocity) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public void updatePosition(int width, int height){
        velocity.updateVelocity();
        updateXPosition(width);
        updateYPosition(height);
    }

    private void updateXPosition(int width){
        x = (int) (x + velocity.getxVelocity());
        if (x > Screen.getInstance().getWidth() - width){
            x = 0;
        }
        else if (x < 0){
            x = Screen.getInstance().getWidth() - width;
        }
    }

    private void updateYPosition(int height){
        y = (int) (y - velocity.getyVelocity());
        if (y > Screen.getInstance().getHeight() - height){
            y = 0;
        }
        else if (y < 0){
            y= Screen.getInstance().getHeight() - height;
        }
    }

}
