package ldts.t09g06.control.audio;

import ldts.t09g06.model.audio.Audio;
import ldts.t09g06.model.audio.AudioLoader;
import ldts.t09g06.model.audio.AudioOption;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;

public class AudioController {
    private final Audio shootingAudio;
    private final Audio gameAudio;
    private final Audio dyingAudio;
    private final Audio monsterAtack;
    private final Audio monsterHit;
    private static AudioController audioController;

    private AudioController() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.shootingAudio = new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/shooting_laser.wav"))), AudioSystem.getClip()));
        this.gameAudio =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/gameloop.wav"))), AudioSystem.getClip()));
        this.dyingAudio =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/dying.wav"))), AudioSystem.getClip()));
        this.monsterAtack =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/punch.wav"))), AudioSystem.getClip()));
        this.monsterHit =  new Audio(new AudioLoader().loadAudio(AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("audio/monster_hit.wav"))), AudioSystem.getClip()));
    }

    public static AudioController getInstance() {
        if(audioController == null){
            try {
                audioController = new AudioController();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize AudioController", e);
            }
        }
        return audioController;
    }

    public void playAudio(AudioOption option) {
        switch (option){
            case SHOOTING -> this.shootingAudio.play();
            case DYING -> this.dyingAudio.play();
            case GAME -> this.gameAudio.startAudioLoop();
            case MONSTER_ATACK -> this.monsterAtack.play();
            case MONSTER_HIT -> this.monsterHit.play();
        }
    }

    public void stopAudio(AudioOption option) {
        switch (option){
            case SHOOTING -> this.shootingAudio.stop();
            case DYING -> this.dyingAudio.stop();
            case GAME -> this.gameAudio.stop();
            case MONSTER_ATACK -> this.monsterAtack.stop();
            case MONSTER_HIT -> this.monsterHit.stop();
        }
    }

    public void stopAllAudio() {
        this.shootingAudio.stop();
        this.dyingAudio.stop();
        this.gameAudio.stop();
        this.gameAudio.stop();
        this.monsterHit.stop();
    }

}
