package ldts.t09g06.model.audio;

import javax.sound.sampled.Clip;

public interface AudioPlayer {
    void startAudioLoop();
    void stop();
    void setAudio(Clip sound);
    Clip getAudio();

}
