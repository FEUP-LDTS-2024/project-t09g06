package ldts.t09g06.view.game;

import ldts.t09g06.gui.GUI;
import ldts.t09g06.model.Position;
import ldts.t09g06.model.game.arena.Arena;
import ldts.t09g06.model.game.elements.Element;
import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.view.Viewer;
import ldts.t09g06.view.ViewerManager;

import java.io.IOException;
import java.util.List;

import static ldts.t09g06.model.Constants.VIEW_SIZE_X;
import static ldts.t09g06.model.Constants.VIEW_SIZE_Y;

public class GameViewer extends Viewer<Arena> {
    private final WallViewer wallViewer;
    private final HeroViewer heroViewer;
    private final MonsterViewer monsterViewer;
    private final AmmoViewer ammoViewer;
    private final TileViewer tileViewer;
    private final BossViewer bossViewer;
    public GameViewer(Arena arena, ViewerManager viewerManager) {
        super(arena);
        this.wallViewer = viewerManager.getWallViewer();
        this.heroViewer = viewerManager.getHeroViewer();
        this.monsterViewer = viewerManager.getMonsterViewer();
        this.ammoViewer = viewerManager.getAmmoViewer();
        this.tileViewer = viewerManager.getTileViewer();
        this.bossViewer = viewerManager.getBossViewer();

    }

    @Override
    public void drawModel(GUI gui){


        drawElements(gui, getModel().getWalls(),wallViewer);
        drawElements(gui, getModel().getTiles(),tileViewer);
        drawElements(gui, getModel().getMonsters(),monsterViewer);
        drawElement(gui, getModel().getHero(),heroViewer);
        if(!getModel().isBossDefeated())
            drawElement(gui, getModel().getBoss(), bossViewer);


        if(!getModel().getBullets().isEmpty())
            drawElements(gui, getModel().getBullets(),ammoViewer);

        gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getLife(), "#FFD700");
        gui.drawText(new Position(11, 0), "Ammo: " + getModel().getHero().getAmmo(), "#FFD700" );
        gui.drawText(new Position(20,0), "Monsters Left: " + getModel().getMonsters().size(), "#FFD700");
        gui.drawText(new Position(39,0),"Score: " + getModel().getHero().getScore(), "#FFD700");
    }
    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private boolean isVisible(GUI gui, Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= gui.getTranslation_actual().getX() &&
                y >= gui.getTranslation_actual().getY() &&
                x < gui.getTranslation_actual().getX() + VIEW_SIZE_X &&
                y < gui.getTranslation_actual().getY() + VIEW_SIZE_Y;
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
