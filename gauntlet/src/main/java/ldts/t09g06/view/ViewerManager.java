package ldts.t09g06.view;

import ldts.t09g06.model.game.elements.heroes.Hero;
import ldts.t09g06.view.game.*;

import java.io.IOException;

public class ViewerManager {
    private final WallViewer wallViewer;
    private final HeroViewer heroViewer;
    private final AmmoViewer ammoViewer;
    private final MonsterViewer monsterViewer;
    private final TileViewer tileViewer;
    private final BossViewer bossViewer;
    private final ReloaderViewer reloaderViewer;
    private final LifeReloaderViewer lifeReloaderViewer;

    public ViewerManager(SpriteLoader spriteLoader) throws IOException {
        this.wallViewer = new WallViewer(spriteLoader);
        this.heroViewer = new HeroViewer(spriteLoader);
        this.ammoViewer = new AmmoViewer(spriteLoader);
        this.monsterViewer = new MonsterViewer(spriteLoader);
        this.tileViewer = new TileViewer(spriteLoader);
        this.bossViewer = new BossViewer(spriteLoader);
        this.reloaderViewer = new ReloaderViewer(spriteLoader);
        this.lifeReloaderViewer = new LifeReloaderViewer(spriteLoader);
    }

    public WallViewer getWallViewer() {return wallViewer;}

    public HeroViewer getHeroViewer() {return heroViewer;}

    public AmmoViewer getAmmoViewer() {return ammoViewer;}

    public MonsterViewer getMonsterViewer() {return monsterViewer;}

    public TileViewer getTileViewer() {return tileViewer;}

    public BossViewer getBossViewer() {return bossViewer;}

    public ReloaderViewer getReloaderViewer(){return reloaderViewer;}

    public LifeReloaderViewer getLifeReloaderViewer(){return lifeReloaderViewer;}
}
