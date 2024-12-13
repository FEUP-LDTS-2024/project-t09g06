package ldts.t09g06.model;

public class Constants {

    // COLORS
    public static final String WHITE = "#FFFFFF";
    public static final String BLACK = "#000000";

    public static final String RED = "#FF0000";
    public static final String GREEN = "#008000";

    public static final String LIGHTGREY = "#D3D3D3";

    public static final String LIGHTBLUE = "#ADD8E6";

    public static final String YELLOW = "#FFD700";

    //MENU

    public static final String MENU = "Menu";

    public static final int menuHeight = 10;
    public static final int menuWidth = 30;

    //insertname menu size

    public static final int insertNameWidth = 100;
    public static final int insertNameHeight = 50;

    public static final int leaderboard_x = 100;
    public static final int leaderboard_y = 50;

    public static int WIDTH;
    public static int HEIGHT;

    public static void setDimensions(int level) {
        switch(level){
            case 0:
                Constants.HEIGHT = HEIGHT1;
                Constants.WIDTH = WIDTH1;
                break;
            case 1:
                Constants.HEIGHT = HEIGHT2;
                Constants.WIDTH = WIDTH2;
                break;
            case 2:
                Constants.HEIGHT = HEIGHT3;
                Constants.WIDTH = WIDTH3;
                break;
            case 3:
                Constants.HEIGHT = HEIGHT4;
                Constants.WIDTH = WIDTH4;
                break;
            case 4:
                Constants.HEIGHT = HEIGHT5;
                Constants.WIDTH = WIDTH5;
                break;
        }

    }
    //GAME SCREEN
    public static final int WIDTH1 = 100;
    public static final int HEIGHT1 = 50;
    public static final int WIDTH2 = 100;
    public static final int HEIGHT2 = 50;
    public static final int WIDTH3 = 100;
    public static final int HEIGHT3 = 50;
    public static final int WIDTH4= 20;
    public static final int HEIGHT4 = 200;
    public static final int WIDTH5= 20;
    public static final int HEIGHT5 = 20;


    //Instructions size
    public static final int INSTRUCTIONS_SIZEX = 95;
    public static final int INSTRUCTIONS_SIZEY = 27;
    //radius around player
    public static int VIEW_SIZE_X = 320;
    public static int VIEW_SIZE_Y = 160;

    // LEADERBOARD
    public static final int maxNameLength = 10;

    //SPRITES
    public static final int SPRITE_SIZE = 16;
}
