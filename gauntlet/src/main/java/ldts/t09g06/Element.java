package ldts.t09g06;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    public Element(int x, int y) {
        this.position = new Position(x,y);
    }
    public Position getPosition(){
        return this.position;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public abstract void draw(TextGraphics graphics);
}
