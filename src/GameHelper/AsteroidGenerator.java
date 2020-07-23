package GameHelper;

import BoardHelpers.Board;
import Entities.Asteroid;
import Entities.BigAsteroid;
import Entities.MediumAsteroid;
import Entities.SmallAsteroid;
import UI.Screen;

public class AsteroidGenerator extends Thread{

    private static final int MAX_ASTEROIDS = 10;
    private boolean running = true;


    @Override
    public void run() {
        super.run();
        while (running){
            generateAsteroids();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateAsteroids() {
        if (Asteroid.getTotalAsteroids() > MAX_ASTEROIDS){
            return;
        }

        double randomX = (Math.random() * Screen.getInstance().getWidth());
        int randomAngle = (int) (Math.random() * ((269 - 89) + 1)) + 89;
        double rng = Math.random();
        if (rng > 0.95){
            generateBigAsteroid(randomX, randomAngle);
        }
        else if (rng > 0.9){
            generateMediumAsteroid(randomX, randomAngle);
        }
        else if (rng > 0.80){
            generateSmallAsteroid(randomX, randomAngle);
        }
    }

    private void generateBigAsteroid(double randomX, int randomAngle){
        BigAsteroid bigAsteroid = new BigAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(bigAsteroid);
    }

    private void generateMediumAsteroid(double randomX, int randomAngle){
        MediumAsteroid mediumAsteroid = new MediumAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(mediumAsteroid);
    }

    private void generateSmallAsteroid(double randomX, int randomAngle){
        SmallAsteroid smallAsteroid = new SmallAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(smallAsteroid);
    }

    public void end(){
        running = false;
    }

}
