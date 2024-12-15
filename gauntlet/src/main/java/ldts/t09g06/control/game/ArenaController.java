package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.game.audio.AudioController;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.audio.AudioPlayer;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.leaderboard.InsertName;
import ldts.t09g06.model.leaderboard.Leaderboard;
import ldts.t09g06.model.menu.Menu;
import ldts.t09g06.states.InsertNameState;
import ldts.t09g06.states.LeaderboardState;
import ldts.t09g06.states.MenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final AmmoController ammoController;
    private final BossController bossController;
    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.ammoController = new AmmoController(arena);
        this.bossController = new BossController(arena);
        try {
            AudioController.getInstance().playAudio(AudioOption.GAME);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25);
            game.setState(new MenuState(new Menu(), game.getSpriteLoader()));
        }
        else if(getModel().getHero().getLife() <= 0) {
            game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25); //this should be included in each setState
            game.setState(new InsertNameState(new InsertName(getModel().getHero()), game.getSpriteLoader()));
        }
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            ammoController.step(game, action, time);
            bossController.step(game, action, time);
        }
    }

    public HeroController getHeroController() {
        return heroController;
    }

    public MonsterController getMonsterController() {
        return monsterController;
    }

    public AmmoController getAmmoController() {
        return ammoController;
    }

    public BossController getBossController(){return bossController;}
}
