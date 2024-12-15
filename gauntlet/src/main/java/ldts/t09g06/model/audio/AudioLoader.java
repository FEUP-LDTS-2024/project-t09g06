package ldts.t09g06.model.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class AudioLoader {
    public Clip loadAudio(AudioInputStream audio, Clip audioClip) {
        try {
            audioClip.open(audio);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
        return audioClip;
    }
}
