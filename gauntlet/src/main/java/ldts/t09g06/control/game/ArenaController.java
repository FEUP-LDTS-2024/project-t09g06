package ldts.t09g06.control.game;

import ldts.t09g06.Game;
import ldts.t09g06.control.game.audio.AudioController;
import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Constants;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.audio.AudioOption;
import ldts.t09g06.model.audio.AudioPlayer;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.ammo.LifeReloader;
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
    private final ReloaderController reloaderController;
    private final LifeReloaderController lifeReloaderController;
    private final ChestController chestController;
    private final Position position;
    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.ammoController = new AmmoController(arena);
        this.bossController = new BossController(arena);
        this.reloaderController = new ReloaderController(arena);
        this.lifeReloaderController = new LifeReloaderController(arena);
        this.chestController = new ChestController(arena);
        this.position = new Position(-2,-2);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25);
            AudioController.getInstance().stopAllAudio();
            game.setState(new MenuState(new Menu(), game.getSpriteLoader()));
        }
        else if(getModel().getHero().getLife() <= 0 || getModel().getChest().getPosition().equals(position)) {
            AudioController.getInstance().playAudio(AudioOption.GAME);
            game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25); //this should be included in each setState
            game.setState(new InsertNameState(new InsertName(getModel().getHero()), game.getSpriteLoader()));
            AudioController.getInstance().stopAllAudio();

        }
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            ammoController.step(game, action, time);
            bossController.step(game, action, time);
            reloaderController.step(game,action, time);
            lifeReloaderController.step(game, action, time);
            chestController.step(game,action,time);
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
