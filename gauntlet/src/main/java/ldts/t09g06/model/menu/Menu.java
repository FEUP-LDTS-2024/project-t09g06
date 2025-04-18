package ldts.t09g06.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu extends GenericMenu{
    public Menu() {
        super();
        this.entries = Arrays.asList("start", "leaderboard","instructions","settings", "exit");
    }
    public boolean isSelectedExit() {
        return isSelected(4);
    }
    public boolean isSelectedSettings(){return isSelected(3);}
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedInstructions(){return isSelected(2);}
    public boolean isSelectedLeaderboard() {
        return isSelected(1);
    }
}