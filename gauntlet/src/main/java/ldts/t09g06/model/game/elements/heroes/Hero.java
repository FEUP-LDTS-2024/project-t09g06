package ldts.t09g06.model.game.elements.heroes;

import ldts.t09g06.model.game.elements.Element;

public class Hero extends Element {

    private int life;
    private int ammo;
    private Direction direction;

    public enum Direction {UP, DOWN, LEFT, RIGHT}
    public Hero(int x,int y, char c){
        super(x,y,c); this.life = 5;this.ammo = 5;
        this.direction = Direction.RIGHT;
    }

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
    public void shoot() {
        if (ammo > 0) {
            ammo--;
        }
    }
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
