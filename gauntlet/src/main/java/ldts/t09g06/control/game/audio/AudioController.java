package ldts.t09g06.control.game.audio;

import ldts.t09g06.model.audio.Audio;
import ldts.t09g06.model.audio.AudioLoader;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.audio.AudioPlayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;

public class AudioController {
    private Audio shootingAudio;
    private Audio gameAudio;

    private Audio dyingAudio;

    private static AudioController audioController;

    private AudioController() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.shootingAudio = new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/shooting_laser.wav"))), AudioSystem.getClip()));
        this.gameAudio =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/imperial_march.wav"))), AudioSystem.getClip()));
        this.dyingAudio =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/dying.wav"))), AudioSystem.getClip()));
    }

    public static AudioController getInstance() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(audioController == null){
            audioController = new AudioController();
        }
        return audioController;
    }

    public void playAudio(AudioOption option) {
        switch (option){
            case SHOOTING -> this.shootingAudio.play();
            case DYING -> this.dyingAudio.play();
            case GAME -> this.gameAudio.startAudioLoop();
        }
    }

    public void stopAudio(AudioOption option) {
        switch (option){
            case SHOOTING -> this.shootingAudio.stop();
            case DYING -> this.dyingAudio.stop();
            case GAME -> this.gameAudio.stop();
        }
    }

    public void stopAllAudio() {
        this.shootingAudio.stop();
        this.dyingAudio.stop();
        this.gameAudio.stop();
    }

}
