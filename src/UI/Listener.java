package UI;

import GameHelper.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        Game.getInstance().handleKeyPress(e);
        Game.getInstance().addKeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Game.getInstance().removeKeyPressed(e);
    }
}
