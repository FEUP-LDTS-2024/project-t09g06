package ldts.t09g06.model.leaderboard;

import ldts.t09g06.model.game.elements.heroes.Hero;

public class InsertName {
    private String name;
    private int maxLength = 10;
    private boolean  invalidInput;

    private Hero hero;
    public InsertName(Hero hero) {
        this.name = "";
        this.hero = hero;
    }

    public boolean isValidInput() {
        return invalidInput;
    }

    public void setInvalidInput(boolean validInput) {
        this.invalidInput = validInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < this.maxLength) {
            this.name = name;
        }
    }

    public Hero getHero() {
        return hero;
    }
}
