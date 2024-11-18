package ldts.t09g06.view;

import ldts.t09g06.gui.LanternaGUI;

public interface ElementViewer <T extends Element> {
    void draw(T element, LanternaGUI gui);
}
