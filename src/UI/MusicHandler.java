package UI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicHandler {
    public static void play() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File songPath = new File("Music/song.wav");
        if (songPath.exists()){
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songPath.getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // set volume to 5%
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            double gain = 0.05;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
