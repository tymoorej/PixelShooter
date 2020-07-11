package Entities;

import GameHelper.Game;
import Motion.Acceleration;
import Motion.Position;
import Motion.Velocity;
import UI.Screen;

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

    public static Player createNewPlayer(){
        return new Player(
                new Ship(
                        new Position(
                                Screen.getInstance().getMiddleX(),
                                Screen.getInstance().getMiddleY(),
                                new Velocity(0, 0,
                                        new Acceleration(0,0)
                                        )
                        )
                )
        );
    }

    public void updatePosition(){
        ship.updatePosition();
    }

}
