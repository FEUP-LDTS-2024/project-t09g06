package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawModel(GUI gui) {


        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());


        if(!getModel().getBullets().isEmpty())
            drawElements(gui, getModel().getBullets(), new AmmoViewer());

        gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getLife(), "#FFD700");
        gui.drawText(new Position(11, 0), "Ammo: " + getModel().getHero().getAmmo(), "#FFD700" );
        gui.drawText(new Position(20,0), "Monsters Left: " + getModel().getMonsters().size(), "#FFD700");
        gui.drawText(new Position(39,0),"Score: " + getModel().getHero().getScore(), "#FFD700");
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}