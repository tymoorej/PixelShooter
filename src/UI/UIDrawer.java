package UI;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.Lock;

import BoardHelpers.*;
import Entities.Player;
import Entities.Ship;
import GameHelper.Game;

public class UIDrawer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        drawPlayer(g);
    }

    private void drawPlayer(Graphics g) {
        Player player = Game.getInstance().getPlayer();
        Ship ship = player.getShip();
        Location location = ship.getLocation();

        Pixel startPixel = location.getStartPixel();
        Pixel endPixel = location.getEndPixel();

        g.drawImage(ship.getImage(), startPixel.getX(), startPixel.getY(), ship.getWidth(), ship.getHeight(), null);
    }
}
