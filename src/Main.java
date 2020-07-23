import GameHelper.Game;
import UI.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {

    private static Game game;

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println("Starting");
        MusicHandler.play();
        UIHandler.setup();
        Game.getInstance().setupGame();

        System.exit(0);
    }
}
