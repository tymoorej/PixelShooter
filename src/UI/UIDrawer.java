package UI;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import BoardHelpers.Board;
import Entities.PhysicalEntity;
import Entities.Ship;
import GameHelper.Game;
import Motion.Position;
import GameHelper.Semaphores;

public class UIDrawer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        Semaphores.getInstance().aquireEntitiesSemaphore();

        for (PhysicalEntity entity: Board.getInstance().getEntities()){
            drawEntity(g, entity);
        }
        Semaphores.getInstance().releaseEntitiesSemaphore();

        Ship ship = Game.getInstance().getShip();
        Position position = ship.getPosition();
        printStats(g, ship, position);
    }

    private void drawEntity(Graphics g, PhysicalEntity entity) {
        Position position = entity.getPosition();
        g.drawImage(entity.getImage(), position.getX(), position.getY(), entity.getWidth(), entity.getHeight(), null);
    }

    private void printStats(Graphics g, Ship ship, Position position){
        long currentTime = System.nanoTime();

        g.setFont(new Font("Speed", Font.BOLD, 15));
        g.setColor(Color.RED);

        long timeDiffSeconds = (currentTime - Game.getInstance().getStartTime()) / 1000000000;
        long timeDiffMinutes = timeDiffSeconds/60;
        long timeDiffSecondsRemainder = timeDiffSeconds % 60;

        String minutesDescriptor = "Minutes";
        if (timeDiffMinutes == 1){
            minutesDescriptor = "Minute";
        }

        String secondsDescriptor = "Seconds";
        if (timeDiffSecondsRemainder == 1){
            secondsDescriptor = "Second";
        }

        g.drawString(
                "Time alive: " + String.valueOf(timeDiffMinutes) + " " + minutesDescriptor + " and " +
                        String.valueOf(timeDiffSecondsRemainder) + " " + secondsDescriptor + ".",
                50, 20);

        DecimalFormat df = new DecimalFormat("#");

        g.setColor(Color.GREEN);
        g.drawString(
                "Angle: " + String.valueOf(ship.getAngle().getAngle()),
                50, 40);
        g.drawString(
                "Position: (" +  String.valueOf(position.getX()) + ", " + String.valueOf(position.getY()) + ")",
                50, 60);
        g.drawString(
                "Velocity: " +  String.valueOf(df.format(position.getVelocity().getVelocity() * 1000) + " KM/H"),
                50, 80);
        g.drawString(
                "Acceleration: " +  String.valueOf(df.format(position.getVelocity().getAcceleration().getAcceleration() * 1000) + " KM/H^2"),
                50, 100);
    }

}
