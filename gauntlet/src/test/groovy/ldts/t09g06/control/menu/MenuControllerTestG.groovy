package ldts.t09g06.control.menu

import ldts.t09g06.gui.LanternaGUI
import ldts.t09g06.model.Constants
import spock.lang.Specification

import ldts.t09g06.Game
import ldts.t09g06.gui.GUI
import ldts.t09g06.model.menu.Menu
import ldts.t09g06.control.menu.MenuController
import ldts.t09g06.states.GameState
import spock.lang.Specification

class MenuControllerTestG extends Specification {
    def game = Mock(Game)
    def gui = Mock(LanternaGUI)
    def menu = Mock(Menu)
    def menuController = new MenuController(menu)

    def setup() {
        menuController.getModel() >> menu
        game.getGui() >> gui
    }

    def "MenuController should move to previous entry when UP action is selected"() {
        given:
            menu.isSelectedExit() >> false
            menu.isSelectedStart() >> false
        when:
            menuController.step(game, GUI.ACTION.UP, 1000)
        then:
            1 * menu.previousEntry()
            0 * menu.nextEntry()
    }

    def "MenuController should move to next entry when DOWN action is selected"() {
        given:
            menu.isSelectedExit() >> false
            menu.isSelectedStart() >> false
        when:
            menuController.step(game, GUI.ACTION.DOWN, 1000)
        then:
            1 * menu.nextEntry()
            0 * menu.previousEntry()
    }

    def "MenuController should start the game when SELECT action is pressed on the start option"() {
        given:
            menu.isSelectedExit() >> false
            menu.isSelectedStart() >> true
        when:
            menuController.step(game, GUI.ACTION.SELECT, 1000)
        then:
            1 * game.getGui().resizeScreen(Constants.WIDTH, Constants.HEIGHT)
            1 * game.setState(_ as GameState)
    }

    def "MenuController should exit the game when SELECT action is pressed on the exit option"() {
        given:
            menu.isSelectedExit() >> true
            menu.isSelectedStart() >> false
        when:
            menuController.step(game, GUI.ACTION.SELECT, 1000)
        then:
            1 * game.setState(null)
    }
}
