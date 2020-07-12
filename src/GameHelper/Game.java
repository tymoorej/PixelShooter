package GameHelper;

import Entities.Player;
import Entities.Ship;
import Motion.Position;
import UI.Screen;
import UI.UIHandler;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Game {
    private static Game instance = null;

    private static GameState gameState;
    private Player player;
    private ArrayList<Integer> pressedKeys;
    private Semaphore semaphore;
    private long startTime;

    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Game() {
        gameState = GameState.NOT_STARTED;
        player = new Player();
        pressedKeys = new ArrayList<>();
        semaphore = new Semaphore(1);
    }

    public void startGame (){
        startTime = System.nanoTime();
        while (true){
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int pressedKey : pressedKeys) {
                handleKeyPress(pressedKey);
            }
            player.updatePosition();
//            System.out.println(player.getShip().getPosition().getY());
//            System.out.println(player.getShip().getPosition().getVelocity().getyVelocity());
//            System.out.println(player.getShip().getPosition().getVelocity().getAcceleration().getyAcceleration());


            semaphore.release();
            UIHandler.update();
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleKeyPress (int e){
        if (e== KeyEvent.VK_UP){
            player.increaseAcceleration();
        }
        if (e == KeyEvent.VK_DOWN){
            player.decreaseAcceleration();
        }
        if (e == KeyEvent.VK_LEFT){
            player.rotateLeft();
        }
        if (e == KeyEvent.VK_RIGHT){
            player.rotateRight();
        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE){
//            player.shoot();
//        }
    }

    public void addKeyPressed(KeyEvent e){
        try {
            semaphore.acquire();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (!pressedKeys.contains(e.getKeyCode())){
            pressedKeys.add(e.getKeyCode());
        }
        semaphore.release();
    }

    public void removeKeyPressed(KeyEvent e){
        try {
            semaphore.acquire();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
        semaphore.release();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        Game.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }

    public long getStartTime() {
        return startTime;
    }
}
