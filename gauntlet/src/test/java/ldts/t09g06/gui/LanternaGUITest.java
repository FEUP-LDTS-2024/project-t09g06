package ldts.t09g06.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import ldts.t09g06.model.Position;
import org.apache.groovy.parser.antlr4.GroovyParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;


public class LanternaGUITest {

    private Screen screen;
    private LanternaGUI lanternaGUI;
    private Position position;
    private TextGraphics textGraphics;

    @BeforeEach
     void setup() {
        position = new Position(30, 30);
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);
        lanternaGUI = new LanternaGUI(screen);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);  // Stubbing method
    }

    @Test
    void testCreateScreen() {

        LanternaGUI newScreen = new LanternaGUI(screen);
        Assertions.assertEquals(screen, newScreen.getScreen(), "LanternaGUI screen should match the mocked screen");    }

}
