package GameHelper;

import BoardHelpers.Board;
import Entities.PhysicalEntity;
import Entities.Ship;
import Entities.SmallAsteroid;
import UI.UIHandler;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Game {
    private static Game instance = null;

    private static GameState gameState;
    private ArrayList<Integer> pressedKeys;
    private long startTime;
    private Ship ship;

    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Game() {
        gameState = GameState.NOT_STARTED;
        pressedKeys = new ArrayList<>();
        ship = new Ship();
        Board.getInstance().addEntity(ship);
    }

    public void startGame (){
        startTime = System.nanoTime();
        gameState = GameState.PLAYING;
        AsteroidGenerator asteroidGenerator = new AsteroidGenerator();
        asteroidGenerator.start();
        try {
            gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gameLoop() throws Exception{
        while (true){
            Semaphores.getInstance().aquireKeysSemaphore();
            for (int pressedKey : pressedKeys) {
                handleKeyPress(pressedKey);
            }
            Semaphores.getInstance().releaseKeysSemaphore();

            Semaphores.getInstance().aquireEntitiesSemaphore();
            for (PhysicalEntity entity: Board.getInstance().getEntities()){
                entity.updatePosition();
            }
            Semaphores.getInstance().releaseEntitiesSemaphore();
            UIHandler.update();
            sleep(20);
        }
    }

    public void handleKeyPress (int e){
        if (e== KeyEvent.VK_UP){
            ship.increaseAcceleration();
        }
        if (e == KeyEvent.VK_DOWN){
            ship.decreaseAcceleration();
        }
        if (e == KeyEvent.VK_LEFT){
            ship.rotateLeft();
        }
        if (e == KeyEvent.VK_RIGHT){
            ship.rotateRight();
        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE){
//            player.shoot();
//        }
    }

    public void addKeyPressed(KeyEvent e){
        Semaphores.getInstance().aquireKeysSemaphore();
        if (!pressedKeys.contains(e.getKeyCode())){
            pressedKeys.add(e.getKeyCode());
        }
        Semaphores.getInstance().releaseKeysSemaphore();
    }

    public void removeKeyPressed(KeyEvent e){
        Semaphores.getInstance().aquireKeysSemaphore();
        pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
        Semaphores.getInstance().releaseKeysSemaphore();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        Game.gameState = gameState;
    }

    public long getStartTime() {
        return startTime;
    }

    public Ship getShip() {
        return ship;
    }

}
