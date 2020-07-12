package Motion;

public class Acceleration {
    private double acceleration;
    private double PositiveAccelerationIncrement;
    private double NegativeAccelerationIncrement;
    private double maxAcceleration;
    private double minAcceleration;

    public Acceleration(double acceleration, double positiveAccelerationIncrement, double negativeAccelerationIncrement, double maxAcceleration, double minAcceleration) {
        this.acceleration = acceleration;
        PositiveAccelerationIncrement = positiveAccelerationIncrement;
        NegativeAccelerationIncrement = negativeAccelerationIncrement;
        this.maxAcceleration = maxAcceleration;
        this.minAcceleration = minAcceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void increaseAcceleration(){
        acceleration = acceleration + PositiveAccelerationIncrement;

        if (acceleration > maxAcceleration){
            acceleration = maxAcceleration;

        }
    }

    public void decreaseAcceleration(){
        acceleration = acceleration - NegativeAccelerationIncrement;

        if (acceleration < minAcceleration){
            acceleration = minAcceleration;
        }
    }

    public void setAcceleration(double yAcceleration) {
        this.acceleration = yAcceleration;
    }
}
