package Motion;

public class Acceleration {
    private double xAcceleration;
    private double yAcceleration;
    private static final double AccelerationIncrement = 0.1;
    private static final double maxAcceleration = 2;
    private static final double minAcceleration = -2;

    public Acceleration(double xAcceleration, double yAcceleration) {
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
    }

    public double getxAcceleration() {
        return xAcceleration;
    }

    public double getyAcceleration() {
        return yAcceleration;
    }

    public void increaseXAcceleration(){
        xAcceleration = xAcceleration + AccelerationIncrement;

        if (xAcceleration > maxAcceleration){
            xAcceleration = maxAcceleration;
        }
    }

    public void decreaseXAcceleration(){
        xAcceleration = xAcceleration - AccelerationIncrement;

        if (xAcceleration < minAcceleration){
            xAcceleration = minAcceleration;
        }
    }

    public void increaseYAcceleration(){
        yAcceleration = yAcceleration + AccelerationIncrement;

        if (yAcceleration > maxAcceleration){
            yAcceleration = maxAcceleration;

        }
    }

    public void decreaseYAcceleration(){
        yAcceleration = yAcceleration - AccelerationIncrement;

        if (yAcceleration < minAcceleration){
            yAcceleration = minAcceleration;
        }
    }

    public void setxAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    public void setyAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }
}
