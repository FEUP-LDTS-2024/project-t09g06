package ldts.t09g06.gui

import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification;
import com.googlecode.lanterna.screen.Screen;
import ldts.t09g06.model.Position;


class LanternaGUITestG extends Specification {

    private def screen;
    private def lanternaGUI;
    private def position;
    private def textGraphics;


    def setup() {
        position = new Position(30,30);
        screen = Mock(Screen.class)
        textGraphics = Mock(TextGraphics.class)
        lanternaGUI = new LanternaGUI(screen)

        screen.newTextGraphics() >> textGraphics
    }

    def 'Create Screen'() {
        when:
            Screen newScreen = lanternaGUI.screen

        then:
            newScreen == screen
    }

}
