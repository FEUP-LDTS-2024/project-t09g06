package ldts.t09g06.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class SpriteMapLoader implements SpriteLoader {
    private final Map<String, Sprite> spritesMap;

    public SpriteMapLoader() { spritesMap = new HashMap<>();}

    @Override
    public Sprite get(String spriteLocation) throws IOException {
        if (!spritesMap.containsKey(spriteLocation))
            spritesMap.put(spriteLocation, new Sprite(spriteLocation));
        return spritesMap.get(spriteLocation);
    }
}
