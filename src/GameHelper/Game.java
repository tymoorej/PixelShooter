package GameHelper;

import BoardHelpers.Board;
import Entities.Player;
import Entities.Ship;
import UI.UIHandler;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Game {
    private static Game instance = null;

    private static GameState gameState;
    private Player player;
    private ArrayList<Integer> pressedKeys;
    private Semaphore semaphore;

    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    private Game() {
        gameState = GameState.NOT_STARTED;
        player = new Player(new Ship(Board.getInstance().getLocation(Board.getInstance().getxSize()/2, Board.getInstance().getySize()/2)));
        pressedKeys = new ArrayList<>();
        semaphore = new Semaphore(1);
    }

    public void startGame (){

        while (true){
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int pressedKey : pressedKeys) {
                handleKeyPress(pressedKey);
            }
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
        if (e== KeyEvent.VK_UP || e == KeyEvent.VK_W){
            player.moveUp();
        }
        if (e == KeyEvent.VK_DOWN || e == KeyEvent.VK_S){
            player.moveDown();
        }
        if (e == KeyEvent.VK_LEFT || e == KeyEvent.VK_A){
            player.rotateLeft();
        }
        if (e == KeyEvent.VK_RIGHT || e == KeyEvent.VK_D){
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
        pressedKeys.add(e.getKeyCode());
        semaphore.release();
    }

    public void removeKeyPressed(KeyEvent e){
        try {
            semaphore.acquire();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        pressedKeys.removeAll(Collections.singletonList(e.getKeyCode()));
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
}
