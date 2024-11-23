package ldts.t09g06.model.game.elements.heroes;

import ldts.t09g06.model.game.elements.Element;

public class Hero extends Element {
    public Hero(int x,int y, char c){super(x,y,c); this.life = 5;this.ammo = 5;}
    private int life;
    private int ammo;
    public int getLife() {
        return life;
    }
    public void decreaseLife(int damage){
        this.life-= damage;
    }
    public void increaseLife(int bonus){
        this.life += bonus;
    }

    public int getAmmo() {
        return ammo;
    }
    public void decreaseAmmo(){
        ammo-=1;
    }
    public void increaseAmmo(int x){
        ammo += 1;
    }
}
