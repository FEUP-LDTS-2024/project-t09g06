package ldts.t09g06.control.game

import ldts.t09g06.Game
import ldts.t09g06.gui.GUI
import ldts.t09g06.gui.LanternaGUI
import ldts.t09g06.model.Constants
import ldts.t09g06.model.Position
import ldts.t09g06.model.game.arena.Arena
import ldts.t09g06.model.game.elements.Wall
import ldts.t09g06.model.game.elements.ammo.GenericAmmo
import ldts.t09g06.model.game.elements.heroes.Hero
import ldts.t09g06.model.game.elements.monsters.GenericMonster
import ldts.t09g06.states.InsertNameState
import ldts.t09g06.states.MenuState
import ldts.t09g06.view.Sprite
import ldts.t09g06.view.SpriteLoader
import spock.lang.Specification
import net.jqwik.api.*

class ArenaControllerTestG extends Specification{

    def arena = Mock(Arena)
    def game = Mock(Game)
    def hero = Mock(Hero)
    def heroController = Mock(HeroController)
    def monsterController = Mock(MonsterController)
    def ammoController = Mock(AmmoController)
    def arenaController = new ArenaController(arena)

    def setup() {
        arenaController.getHeroController() >> heroController
        arenaController.getMonsterController() >> monsterController
        arenaController.getAmmoController() >> ammoController
        arena.getHero() >> hero
        game.getGui() >> Mock(LanternaGUI)
        game.getSpriteLoader()  >> Mock(SpriteLoader)
    }

    def "Game should end and transition to Menu when hero's life is 0"() {
        given:
            hero.getLife() >> 0
        when:
            arenaController.step(game, GUI.ACTION.NONE, 1000)
        then:
            1 * game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25);
            1 * game.setState(_ as InsertNameState)
            0 * heroController.step(_, _, _)
            0 * monsterController.step(_, _, _)
            0 * ammoController.step(_, _, _)
    }

    def "Game should transition to Menu when quit action is triggered"() {
        given:
            hero.getLife() >> 5

        when:
            arenaController.step(game, GUI.ACTION.QUIT, 1000)

        then:
            1 * game.getGui().changeScreen(Constants.menuWidth, Constants.menuHeight, 25);
            1 * game.setState(_ as MenuState)
            0 * heroController.step(_, _, _)
            0 * monsterController.step(_, _, _)
            0 * ammoController.step(_, _, _)
    }

}




