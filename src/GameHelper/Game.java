package GameHelper;

import BoardHelpers.Board;
import Entities.PhysicalEntity;
import Entities.Ship;
import UI.UIHandler;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Game {
    private static Game instance = null;

    private static GameState gameState;
    private ArrayList<Integer> pressedKeys;
    private long startTime;
    private long finalEndTime;
    private Ship ship;
    private boolean exitGame;
    private AsteroidGenerator asteroidGenerator;
    private CollisionDetector collisionDetector;

    private final boolean DEBUG_MODE = false;

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
        exitGame = false;
    }

    public void setupGame() throws InterruptedException {
        while (getGameState() != GameState.PLAYING){
            UIHandler.update();
            sleep(20);
        }
        startGame();
    }

    public void startGame (){
        startTime = System.nanoTime();
        gameState = GameState.PLAYING;

        asteroidGenerator = new AsteroidGenerator();
        asteroidGenerator.start();

        collisionDetector = new CollisionDetector();
        collisionDetector.start();

        try {
            gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gameLoop() throws Exception{
        while (Game.getInstance().getGameState() == GameState.PLAYING){
            executeKeyPresses();
            updateEntityPositions();
            deleteFlaggedEntities();
            addNewEntities();
            UIHandler.update();
            sleep(20);
        }
        gameOver();
    }


    private void gameOver() throws InterruptedException {
        finalEndTime = System.nanoTime();
        asteroidGenerator.end();
        collisionDetector.end();
        gameOverLoop();
    }

    private void gameOverLoop() throws InterruptedException {
        while (!exitGame){
            UIHandler.update();
            sleep(20);
        }
    }

    private void executeKeyPresses(){
        Semaphores.getInstance().aquireKeysSemaphore();
        for (int pressedKey : pressedKeys) {
            handleKeyPress(pressedKey);
        }
        Semaphores.getInstance().releaseKeysSemaphore();
    }

    private void updateEntityPositions(){
        Semaphores.getInstance().aquireEntitiesSemaphore();
        for (PhysicalEntity entity: Board.getInstance().getEntities()){
            entity.updatePosition();
        }
        Semaphores.getInstance().releaseEntitiesSemaphore();
    }

    private void deleteFlaggedEntities(){
        Semaphores.getInstance().aquireDeleteQueueSemaphore();
        for (PhysicalEntity entity: Board.getInstance().getDeleteQueue()){
            entity.delete();
        }
        Board.getInstance().clearDeleteQueue();
        Semaphores.getInstance().releaseDeleteQueueSemaphore();
    }

    private void addNewEntities() {
        Semaphores.getInstance().aquireEntitiesQueueSemaphore();
        for (PhysicalEntity entity: Board.getInstance().getEntitiesQueue()){
            Board.getInstance().addEntity(entity);
        }
        Board.getInstance().clearEntitiesQueue();
        Semaphores.getInstance().releaseEntitiesQueueSemaphore();
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
    }

    public void addKeyPressed(KeyEvent e){
        Semaphores.getInstance().aquireKeysSemaphore();
        if (!pressedKeys.contains(e.getKeyCode())){
            pressedKeys.add(e.getKeyCode());
        }
        Semaphores.getInstance().releaseKeysSemaphore();
    }

    public void removeKeyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            ship.shoot();
        }

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

    public boolean getDebugMode() {
        return DEBUG_MODE;
    }

    public void exitGame(){
        assert getGameState() == GameState.GAME_OVER;
        exitGame = true;
    }

    public long getFinalEndTime() {
        return finalEndTime;
    }
}
