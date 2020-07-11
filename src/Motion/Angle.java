package Motion;

import ImageHelpers.ImageHelper;

public class Angle {
    private int angle;

    public Angle(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void rotateLeft() {
        angle = angle - 10;
        if (angle < 0){
            angle = 350;
        }
    }

    public void rotateRight() {
        angle = angle + 10;
        if (angle > 360){
            angle = 10;
        }
    }
}
