package ldts.t09g06.model.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class Audio implements AudioPlayer {

    private Clip audioFile;


    public Audio(Clip audio) {
        this.audioFile = audio;
    }

    @Override
    public void startAudioLoop() {
        audioFile.setMicrosecondPosition(0);
        audioFile.start();
        audioFile.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play(){
        if(audioFile.isRunning()){
            stop();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        audioFile.setFramePosition(0);
        audioFile.start();
    }


    @Override
    public void stop() {
        audioFile.stop();
    }

    @Override
    public void setAudio(Clip audio) {
        this.audioFile = audio;
    }

    @Override
    public Clip getAudio() {
        return this.audioFile;
    }
}
