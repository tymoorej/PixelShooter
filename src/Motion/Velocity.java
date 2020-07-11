package Motion;

public class Velocity {
    private double xVelocity;
    private double yVelocity;

    private Acceleration acceleration;

    private static final double maxVelocity = 50;
    private static final double minVelocity = -5;

    public Velocity(double xVelocity, double yVelocity, Acceleration acceleration) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.acceleration = acceleration;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void updateVelocity(){
        updateXVelocity();
        updateYVelocity();
    }

    private void updateXVelocity(){
        xVelocity = xVelocity + acceleration.getxAcceleration();
        if (xVelocity > maxVelocity){
            xVelocity = maxVelocity;
            acceleration.setxAcceleration(0);
        }
        else if (xVelocity < minVelocity){
            xVelocity = minVelocity;
            acceleration.setxAcceleration(0);
        }

        yVelocity = adjustForFriction(yVelocity);
    }

    private void updateYVelocity(){
        yVelocity = yVelocity + acceleration.getyAcceleration();

        if (yVelocity > maxVelocity){
            yVelocity = maxVelocity;
            acceleration.setyAcceleration(0);
        }
        else if (yVelocity < minVelocity){
            yVelocity = minVelocity;
            acceleration.setyAcceleration(0);
        }

        yVelocity = adjustForFriction(yVelocity);
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
