package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.gui.LanternaGUI;
import ldts.t09g06.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}