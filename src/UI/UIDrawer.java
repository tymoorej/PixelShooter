package UI;

import javax.swing.*;
import java.awt.*;

import Entities.Player;
import Entities.Ship;
import GameHelper.Game;
import Motion.Position;

public class UIDrawer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Player player = Game.getInstance().getPlayer();
        Ship ship = player.getShip();
        Position position = ship.getPosition();

        drawPlayer(g, ship, position);
        printStats(g, ship, position);
    }

    private void drawPlayer(Graphics g, Ship ship, Position position) {
        g.drawImage(ship.getImage(), position.getX(), position.getY(), ship.getWidth(), ship.getHeight(), null);
    }

    private void printStats(Graphics g, Ship ship, Position position){
        g.setColor(Color.GREEN);
        g.setFont(new Font("Speed", Font.BOLD, 15));
        g.drawString(
                "Angle: " + String.valueOf(ship.getAngle().getAngle()),
                50, 30);
        g.drawString(
                "Position: (" +  String.valueOf(position.getX()) + ", " + String.valueOf(position.getY()) + ")",
                50, 50);
        g.drawString(
                "Velocity: (" +  String.valueOf(position.getVelocity().getxVelocity()) + ", " +
                        String.valueOf(position.getVelocity().getyVelocity()) + ")",
                50, 70);
        g.drawString(
                "Acceleration: (" +  String.valueOf(position.getVelocity().getAcceleration().getxAcceleration()) +
                        ", " + String.valueOf(position.getVelocity().getAcceleration().getyAcceleration()) + ")",
                50, 90);
    }

}
