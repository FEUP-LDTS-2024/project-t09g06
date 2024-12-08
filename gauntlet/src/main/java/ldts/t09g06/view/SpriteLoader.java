package ldts.t09g06.view;

import java.io.IOException;

public interface SpriteLoader {
    Sprite get(String SpriteLocation) throws IOException;
}
