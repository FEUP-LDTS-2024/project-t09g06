package ldts.t09g06.view.game;


import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}