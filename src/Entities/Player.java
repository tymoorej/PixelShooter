package Entities;

public class Player {
    private Ship ship;

    public Player() {
        this.ship = new Ship();
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void increaseAcceleration(){
        ship.increaseAcceleration();
    }

    public void decreaseAcceleration(){
        ship.decreaseAcceleration();
    }

    public void rotateLeft() {
        ship.rotateLeft();
    }

    public void rotateRight() {
        ship.rotateRight();
    }

    public void updatePosition(){
        ship.updatePosition();
    }

}
