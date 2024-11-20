package GameSystem;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(String filePath) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(filePath);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioSrc);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void loop() {
        if (clip != null)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        if (clip != null && clip.isRunning())
            clip.stop();
    }
    
}
