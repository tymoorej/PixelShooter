package Motion;

public class Velocity {
    private double velocity;
    private double maxVelocity;
    private double minVelocity;
    private boolean adjustForFriction;

    private Acceleration acceleration;

    public Velocity(double velocity, double maxVelocity, double minVelocity, Acceleration acceleration, boolean adjustForFriction) {
        this.velocity = velocity;
        this.maxVelocity = maxVelocity;
        this.minVelocity = minVelocity;
        this.acceleration = acceleration;
        this.adjustForFriction = adjustForFriction;
    }

    public double getVelocity() {
        return velocity;
    }

    public void updateVelocity(){
        acceleration.updateAcceleration();
        velocity = velocity + acceleration.getAcceleration();

        if (velocity > maxVelocity){
            velocity = maxVelocity;
            acceleration.setAcceleration(0);
        }
        else if (velocity < minVelocity){
            velocity = minVelocity;
            acceleration.setAcceleration(0);
        }

        if (adjustForFriction){
            velocity = adjustForFriction(velocity);
        }
    }

    public double adjustForFriction(double velocity){
        if (velocity > 0 && velocity <= 0.01 * maxVelocity){
            return velocity * 0.50;
        }
        else if (velocity < 0 && velocity >= 0.01 * minVelocity){
            return velocity * 0.50;
        }
        else{
            return velocity;
        }
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }



}
