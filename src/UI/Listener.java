package UI;

import GameHelper.Game;
import GameHelper.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Game.getInstance().getGameState() == GameState.NOT_STARTED && e.getKeyCode() == KeyEvent.VK_ENTER){
            Game.getInstance().setGameState(GameState.PLAYING);
        }
        else if (Game.getInstance().getGameState() == GameState.PLAYING && e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Game.getInstance().setGameState(GameState.GAME_OVER);
        }
        else if (Game.getInstance().getGameState() == GameState.PLAYING){
            Game.getInstance().addKeyPressed(e);
        }
        else if (Game.getInstance().getGameState() == GameState.GAME_OVER && e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Game.getInstance().exitGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Game.getInstance().getGameState() == GameState.PLAYING){
            Game.getInstance().removeKeyPressed(e);
        }
    }
}
