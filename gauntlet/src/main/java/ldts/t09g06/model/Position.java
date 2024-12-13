package ldts.t09g06.model;

import ldts.t09g06.model.game.arena.Arena;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public  Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }

    public Position getCloserTo(Arena arena, Position p){
        //for now just return random
        int hx = p.getX();
        int hy = p.getY();
        int mx = x;
        int my = y;
        int difx = mx -hx;
        int dify = my -hy;
        if(Math.abs(mx-hx) < 10 && Math.abs(my-hy) < 10){
            if(Math.abs(dify) > Math.abs(difx)){
                if(dify>0 && !arena.wallCollision(getUp())) return getUp();
                else if(dify<0 && !arena.wallCollision(getDown())) return getDown();
            }
            if (difx>0 && !arena.wallCollision(getLeft()))return getLeft();
            else if(difx<0 && !arena.wallCollision((getRight()))) return getRight();
            if(dify>0 && !arena.wallCollision(getUp())) return getUp();
            else if(dify<0 && !arena.wallCollision(getDown())) return getDown();
        }
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                return getUp();
            case 1:
                return getRight();
            case 2:
                return getDown();
            default:
                return getLeft();
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
