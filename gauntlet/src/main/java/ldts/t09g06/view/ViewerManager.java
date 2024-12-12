package ldts.t09g06.view;

import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.view.game.AmmoViewer;
import ldts.t09g06.view.game.HeroViewer;
import ldts.t09g06.view.game.MonsterViewer;
import ldts.t09g06.view.game.WallViewer;

import java.io.IOException;

public class ViewerManager {
    private final WallViewer wallViewer;
    private final HeroViewer heroViewer;
    //private final AmmoViewer ammoViewer;
    private final MonsterViewer monsterViewer;
    //private final TileViewer tileViewer;

    public ViewerManager(SpriteLoader spriteLoader) throws IOException {
        this.wallViewer = new WallViewer(spriteLoader);
        this.heroViewer = new HeroViewer(spriteLoader);
        //this.ammoViewer = new AmmoViewer(spriteLoader);
        this.monsterViewer = new MonsterViewer(spriteLoader);
        //this.tileViewer = new TileViewer(spriteLoader);
    }

    public WallViewer getWallViewer() {return wallViewer;}

    public HeroViewer getHeroViewer() {return heroViewer;}

    //public AmmoViewer getAmmoViewer() {return ammoViewer;}

    public MonsterViewer getMonsterViewer() {return monsterViewer;}

    //public TileViewer getTileViewer() {return tileViewer;}
}
