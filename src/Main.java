import GameHelper.Game;
import UI.*;

import static java.lang.Thread.sleep;

public class Main {

    private static Game game;

    public static void main(String[] args){
        System.out.println("Starting");
        Game.getInstance();
        UIHandler.setup();
        run();
        System.exit(0);
    }

    private static void run() {
        Game.getInstance().startGame();
    }
}
