package UI;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import BoardHelpers.Board;
import Entities.PhysicalEntity;
import Entities.Ship;
import GameHelper.Game;
import GameHelper.GameState;
import ImageHelpers.ImageHelper;
import Motion.Position;
import GameHelper.Semaphores;

public class UIDrawer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        switch (Game.getInstance().getGameState()){
            case NOT_STARTED:
                setupGame(g);
                break;
            case PLAYING:
                playingGame(g);
                break;
            case GAME_OVER:
                gameOver(g);
                break;
        }
    }

    private void setupGame(Graphics g){
        int middleX = Screen.getInstance().getMiddleX();
        int middleY = Screen.getInstance().getMiddleY();
        g.setFont(new Font("Title", Font.BOLD | Font.ITALIC, 50));
        g.setColor(Color.GREEN);
        g.drawString(
                "Asteroid Shooter: Survival Mode",
                middleX - 380, middleY - 400);

        g.setColor(Color.CYAN);
        g.setFont(new Font("Controls Title", Font.BOLD, 30));
        g.drawString("Controls:",
                middleX - 100, middleY - 300);

        g.drawImage(ImageHelper.loadImage("up"), middleX - 150, middleY - 250, 75, 75, null);

        g.setFont(new Font("Controls", Font.BOLD, 24));
        g.drawString("Up: Speed Up",
                middleX, middleY - 200);

        g.drawImage(ImageHelper.loadImage("down"), middleX - 150, middleY - 150, 75, 75, null);

        g.drawString("Down: Slow Down",
                middleX, middleY - 100);

        g.drawImage(ImageHelper.loadImage("left"), middleX - 150, middleY - 50, 75, 75, null);

        g.drawString("Left: Rotate Left",
                middleX, middleY);

        g.drawImage(ImageHelper.loadImage("right"), middleX - 150, middleY + 50, 75, 75, null);

        g.drawString("Right: Rotate Right",
                middleX, middleY + 100);

        g.drawImage(ImageHelper.loadImage("space"), middleX - 150, middleY + 150, 75, 75, null);

        g.drawString("Space: Shoot Laser",
                middleX, middleY + 200);

        g.drawImage(ImageHelper.loadImage("enter"), middleX - 150, middleY + 250, 75, 75, null);

        g.drawString("Enter: Start Game",
                middleX, middleY + 300);

        g.drawImage(ImageHelper.loadImage("esc"), middleX - 150, middleY + 350, 75, 75, null);

        g.drawString("Escape: End Game",
                middleX, middleY + 400);
    }

    private void gameOver(Graphics g){
        int middleX = Screen.getInstance().getMiddleX();
        int middleY = Screen.getInstance().getMiddleY();
        g.setFont(new Font("Title", Font.BOLD | Font.ITALIC, 50));

        g.setColor(Color.decode("#C947F5"));
        g.drawString(
                "GAME OVER!!! :(",
                middleX - 180, middleY - 200);

        g.setColor(Color.GREEN);
        g.drawString(
                "Asteroid Shooter: Survival Mode",
                middleX - 380, middleY - 100);

        g.setColor(Color.RED);
        long timeDiffSeconds = (Game.getInstance().getFinalEndTime() - Game.getInstance().getStartTime()) / 1000000000;
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
                middleX - 420, middleY);

        g.setColor(Color.CYAN);
        g.drawString(
                "Press Escape to exit the application.",
                middleX - 420, middleY + 100);

    }

    private void playingGame(Graphics g){
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
        g.drawImage(entity.getImage(), (int) position.getX(), (int) position.getY(), entity.getWidth(), entity.getHeight(), null);
    }

    private void printStats(Graphics g, Ship ship, Position position){
        long currentTime = System.nanoTime();

        g.setFont(new Font("Text", Font.BOLD, 15));
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


        if (Game.getInstance().getDebugMode()){
            DecimalFormat df = new DecimalFormat("#.00");
            g.setColor(Color.GREEN);
            g.drawString(
                    "Angle: " + String.valueOf(ship.getAngle().getAngle()),
                    50, 40);
            g.drawString(
                    "Position: (" +  String.valueOf(df.format(position.getX())) + ", " + String.valueOf(df.format(position.getY())) + ")",
                    50, 60);
            g.drawString(
                    "Speed: " +  String.valueOf(df.format(position.getVelocity().getVelocity())),
                    50, 80);
            g.drawString(
                    "Acceleration: " +  String.valueOf(df.format(position.getVelocity().getAcceleration().getAcceleration())),
                    50, 100);
        }
    }

}
