package ldts.t09g06.model.game.elements;

import ldts.t09g06.model.Position;

public abstract class Element {
    protected Position position;
     protected char element;

    public Element(int x, int y, char c) {

        this.position = new Position(x,y);
        this.element = c;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setElement(char c) {
        this.element = c;
    }

    public char getElement() { return  this.element;}


    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Element)){
            return false;
        }
        return this.getPosition().equals(((Element) o).getPosition());
    }
}
