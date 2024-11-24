package ldts.t09g06

import ldts.t09g06.gui.LanternaGUI
import ldts.t09g06.model.menu.Menu
import ldts.t09g06.states.GameState
import ldts.t09g06.states.MenuState
import ldts.t09g06.states.State
import spock.lang.Specification

class GameTestG extends Specification{

    def "Game initializes with MenuState and correct GUI"() {
        given:
            def gui = Mock(LanternaGUI)
            def state = Mock(State)
            def menu = Mock(Menu)
            def menuState = new MenuState(menu)

        when:
            def game = Spy(Game)
            game.setState(menuState)

        then:
            game.getGui() != null
            game.state instanceof MenuState
    }
    def "Game transitions between states correctly"() {
        given:
            def gui = Mock(LanternaGUI)
            def initialState = Mock(State)
            def nextState = Mock(State)
            def game = Spy(new Game()) {
                getGui() >> gui
            }
            game.setState(initialState)
        when:
            game.setState(nextState)
        then:
            game.state == nextState
    }

}
