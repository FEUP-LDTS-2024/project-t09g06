package ldts.t09g06.view;

import com.googlecode.lanterna.TextColor;
import ldts.t09g06.gui.GUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static ldts.t09g06.model.Constants.SPRITE_SIZE;

public class Sprite {
    private final BufferedImage image;

    public BufferedImage getImage() {return image;}

    public Sprite(String Location) throws IOException {
        URL reference = getClass().getClassLoader().getResource(Location);
        this.image = ImageIO.read(Objects.requireNonNull(reference));
    }

    public void draw(GUI gui, double x, double y) {
        for (int xx = 0; xx < image.getWidth(); xx++) {
            for (int yy = 0; yy < image.getHeight(); yy++) {
                int argb = image.getRGB(xx, yy);
                int alpha = (argb >> 24) & 0xff;
                if (alpha == 0) continue;
                gui.drawPixel(xx + x*SPRITE_SIZE, yy + y*SPRITE_SIZE, getRGB(argb));
            }
        }
    }

    private TextColor getRGB(int ARGB) {
        int red = ARGB >> 16 & 0xFF;
        int green = ARGB >> 8 & 0xFF;
        int blue = ARGB & 0xFF;
        return new TextColor.RGB(red, green, blue);
    }




}
