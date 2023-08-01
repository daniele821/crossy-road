package game.model.entity;

import static game.model.entity.GameObjectKind.*;

public enum GameObjectType {
    BAC_BIKE_LANE("game/entity/background/bike_lane.png", BACKGROUND),
    BAC_GRASS("game/entity/background/grass.png", BACKGROUND),
    BAC_RAIL("game/entity/background/rail.png", BACKGROUND),
    BAC_ROAD("game/entity/background/road.png", BACKGROUND),
    BAC_WATER("game/entity/background/water.png", BACKGROUND),
    COI_COIN("game/entity/coin/coin.png", COIN),
    PLA_DEFAULT("game/entity/player/default.png", PLAYER),
    PLA_HULK("game/entity/player/hulk.png", PLAYER),
    PLA_SPONGEBOB("game/entity/player/spongebob.png", PLAYER),
    PLA_STEVE("game/entity/player/steve.png", PLAYER),
    PLA_SUPERMAN("game/entity/player/superman.png", PLAYER),
    PLA_THIEF("game/entity/player/thief.png", PLAYER),
    POW_IMMORTALITY("game/entity/powerup/immortality.png", POWERUP),
    POW_MAGNET("game/entity/powerup/magnet.png", POWERUP),
    POW_MULTIPLIER("game/entity/powerup/multiplier.png", POWERUP);

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
