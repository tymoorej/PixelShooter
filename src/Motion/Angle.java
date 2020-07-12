package Motion;

import ImageHelpers.ImageHelper;

public class Angle {
    private int angle;
    private int maxAngleRotation;

    public Angle(int angle, int maxAngleRotation) {
        this.angle = angle;
        this.maxAngleRotation = maxAngleRotation;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void rotateLeft() {
        angle = angle - maxAngleRotation;
        if (angle < 0){
            angle = 360 - maxAngleRotation;
        }
    }

    public void rotateRight() {
        angle = angle + maxAngleRotation;
        if (angle > 360){
            angle = maxAngleRotation;
        }
    }
}
