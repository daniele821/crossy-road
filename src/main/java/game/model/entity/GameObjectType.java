package game.model.entity;

import static game.model.entity.GameObjectKind.*;

public enum GameObjectType {
    BG_BIKE_LANE("game/entity/background/bike_lane.png", BACKGROUND),
    BG_GRASS("game/entity/background/grass.png", BACKGROUND),
    BG_RAIL("game/entity/background/rail.png", BACKGROUND),
    BG_ROAD("game/entity/background/road.png", BACKGROUND),
    BG_WATER("game/entity/background/water.png", BACKGROUND),
    PL_DEFAULT("game/entity/player/default.png", PLAYER),
    PL_HULK("game/entity/player/hulk.png", PLAYER),
    PL_SPONGEBOB("game/entity/player/spongebob.png", PLAYER),
    PL_STEVE("game/entity/player/steve.png", PLAYER),
    PL_SUPERMAN("game/entity/player/superman.png", PLAYER),
    PL_THIEF("game/entity/player/thief.png", PLAYER);

    private final String imageClassPath;
    private final GameObjectKind objectKind;

    private GameObjectType(final String imageClassPath, final GameObjectKind objectKind) {
        this.imageClassPath = imageClassPath;
        this.objectKind = objectKind;
    }

    public String getImageClassPath() {
        return this.imageClassPath;
    }

    public GameObjectKind getGameObjectKind() {
        return this.objectKind;
    }

}
