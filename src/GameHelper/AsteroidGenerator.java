package GameHelper;

import BoardHelpers.Board;
import Entities.BigAsteroid;
import Entities.MediumAsteroid;
import Entities.SmallAsteroid;
import UI.Screen;

public class AsteroidGenerator extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            generateAsteroids();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateAsteroids() {
        int randomX = (int) (Math.random() * Screen.getInstance().getWidth());
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

    private void generateBigAsteroid(int randomX, int randomAngle){
        BigAsteroid bigAsteroid = new BigAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(bigAsteroid);
    }

    private void generateMediumAsteroid(int randomX, int randomAngle){
        MediumAsteroid mediumAsteroid = new MediumAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(mediumAsteroid);
    }

    private void generateSmallAsteroid(int randomX, int randomAngle){
        SmallAsteroid smallAsteroid = new SmallAsteroid(randomX, 0, randomAngle);
        Board.getInstance().addEntity(smallAsteroid);
    }

}
