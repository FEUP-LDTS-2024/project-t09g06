package ldts.t09g06.model.game.elements.ammo;

import ldts.t09g06.model.game.elements.monsters.GenericMonster;

public class Bullet extends GenericAmmo{
    public Bullet(int x, int y, char c, int dx, int dy, boolean isFromBoss){
        super(x,y, c,dx,dy,isFromBoss);
    }
}
