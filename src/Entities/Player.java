package Entities;

import GameHelper.Game;

public class Player {
    private Ship ship;

    public Player(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void moveUp(){
        ship.moveUp();
    }
    public void moveDown(){
        ship.moveDown();
    }
    public void rotateLeft(){
        ship.rotateLeft();
    }
    public void rotateRight(){
        ship.rotateRight();
    }

}
