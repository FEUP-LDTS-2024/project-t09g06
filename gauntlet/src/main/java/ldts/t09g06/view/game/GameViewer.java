package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Screen;
import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Screen> {
    public GameViewer(Screen screen) {
        super(screen);
    }

    @Override
    public void drawModel(GUI gui) {
        Screen screen = getModel();

        int startX = screen.getScreenX();
        int startY = screen.getScreenY();
        int endX = startX + screen.getScreenWidth();
        int endY = startY + screen.getScreenHeight();

        // Draw elements within the viewport boundaries
        drawElementsInScreen(gui, screen.getWalls(), startX, startY, endX, endY, new WallViewer());
        drawElementsInScreen(gui, screen.getMonsters(), startX, startY, endX, endY, new MonsterViewer());
        drawElementInScreen(gui, screen.getHero(), startX, startY, endX, endY, new HeroViewer());

        if (!screen.getBullets().isEmpty()) {
            drawElementsInScreen(gui, screen.getBullets(), startX, startY, endX, endY, new AmmoViewer());
        }

        // Draw UI elements
        gui.drawText(new Position(0, 0), "Energy: " + screen.getHero().getLife(), "#FFD700");
        gui.drawText(new Position(11, 0), "Ammo: " + screen.getHero().getAmmo(), "#FFD700");
        gui.drawText(new Position(20, 0), "Monsters Left: " + screen.getMonsters().size(), "#FFD700");
        gui.drawText(new Position(39, 0), "Score: " + screen.getHero().getScore(), "#FFD700");
    }

    private <T extends Element> void drawElementsInScreen(GUI gui, List<T> elements, int startX, int startY, int endX, int endY, ElementViewer<T> viewer) {
        for (T element : elements) {
            if (isInScreen(element.getPosition(), startX, startY, endX, endY)) {
                viewer.draw(element, gui);
            }
        }
    }

    private <T extends Element> void drawElementInScreen(GUI gui, T element, int startX, int startY, int endX, int endY, ElementViewer<T> viewer) {
        if (isInScreen(element.getPosition(), startX, startY, endX, endY)) {
            viewer.draw(element, gui);
        }
    }

    private boolean isInScreen(Position position, int startX, int startY, int endX, int endY) {
        return position.getX() >= startX && position.getX() < endX && position.getY() >= startY && position.getY() < endY;
    }
}
