package ldts.t09g06.view;

import ldts.t09g06.gui.GUI;
import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawModel(gui);
        gui.refresh();
    }

    public abstract void drawModel(GUI gui);
}