package ldts.t09g06.model.menu;

import java.util.Arrays;

public class MenuSettings extends GenericMenu{
    private int current_difficulty;
    public MenuSettings(int current_difficulty){
        super();
        this.current_difficulty = current_difficulty;
        updateEntries();
    }

    public int getCurrent_difficulty() {
        return current_difficulty;
    }

    public void setCurrent_difficulty(int current_difficulty) {
        this.current_difficulty = current_difficulty;
    }
    public void updateEntries(){
        switch (current_difficulty){
            case 0:
                this.entries = Arrays.asList( "EASY -> *", "medium", "hard", "impossible");
                break;
            case 1:
                this.entries = Arrays.asList( "easy", "MEDIUM -> *", "hard", "impossible");
                break;
            case 2:
                this.entries = Arrays.asList( "easy", "medium", "HARD -> *", "impossible");
                break;
            case 3:
                this.entries = Arrays.asList( "easy", "medium", "hard", "IMPOSSIBLE -> *");
                break;
        }
    }
}
