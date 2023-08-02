package game.model.entity;

import static game.model.entity.GameObjectType.GameObjectKind.BACKGROUND;
import static game.model.entity.GameObjectType.GameObjectKind.COIN;
import static game.model.entity.GameObjectType.GameObjectKind.ENEMY;
import static game.model.entity.GameObjectType.GameObjectKind.OBSTACLE;
import static game.model.entity.GameObjectType.GameObjectKind.PLAYER;
import static game.model.entity.GameObjectType.GameObjectKind.POWERUP;

public enum GameObjectType {
    BAC_BIKE_LANE("game/entity/background/bike_lane.png", BACKGROUND),
    BAC_GRASS("game/entity/background/grass.png", BACKGROUND),
    BAC_RAIL("game/entity/background/rail.png", BACKGROUND),
    BAC_ROAD("game/entity/background/road.png", BACKGROUND),
    BAC_WATER("game/entity/background/water.png", BACKGROUND),
    COI_COIN("game/entity/coin/coin.png", COIN),
    ENE_CAR_1_DX("game/entity/enemy/car_1_dx", ENEMY),
    ENE_CAR_1_SX("game/entity/enemy/car_1_sx", ENEMY),
    ENE_CAR_2_DX("game/entity/enemy/car_2_dx", ENEMY),
    ENE_CAR_2_SX("game/entity/enemy/car_2_sx", ENEMY),
    ENE_CAR_3_DX("game/entity/enemy/car_3_dx", ENEMY),
    ENE_CAR_3_SX("game/entity/enemy/car_3_sx", ENEMY),
    ENE_BIKE_DX("game/entity/enemy/bike_dx", ENEMY),
    ENE_BIKE_SX("game/entity/enemy/bike_sx", ENEMY),
    ENE_TRAIN_2_DX("game/entity/enemy/train_2_dx.png", ENEMY),
    ENE_TRAIN_2_SX("game/entity/enemy/train_2_sx.png", ENEMY),
    ENE_TRAIN_3_DX("game/entity/enemy/train_3_dx.png", ENEMY),
    ENE_TRAIN_3_SX("game/entity/enemy/train_3_sx.png", ENEMY),
    ENE_TRAIN_4_DX("game/entity/enemy/train_4_dx.png", ENEMY),
    ENE_TRAIN_4_SX("game/entity/enemy/train_4_sx.png", ENEMY),
    ENE_TRAIN("game/entity/enemy/train.png", ENEMY),
    OBS_BUSH("game/entity/obstacle/bush.png", OBSTACLE),
    OBS_TREE("game/entity/obstacle/tree.png", OBSTACLE),
    PLA_DEFAULT("game/entity/player/default.png", PLAYER),
    PLA_HULK("game/entity/player/hulk.png", PLAYER),
    PLA_SPONGEBOB("game/entity/player/spongebob.png", PLAYER),
    PLA_STEVE("game/entity/player/steve.png", PLAYER),
    PLA_SUPERMAN("game/entity/player/superman.png", PLAYER),
    PLA_THIEF("game/entity/player/thief.png", PLAYER),
    POW_IMMORTALITY("game/entity/powerup/immortality.png", POWERUP),
    POW_MAGNET("game/entity/powerup/magnet.png", POWERUP),
    POW_MULTIPLIER("game/entity/powerup/multiplier.png", POWERUP);

    private final String imagePath;
    private final GameObjectKind objectKind;

    GameObjectType(final String imagePath, final GameObjectKind objectKind) {
        this.imagePath = imagePath;
        this.objectKind = objectKind;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public GameObjectKind getObjectKind() {
        return this.objectKind;
    }

    public enum GameObjectKind {
        BACKGROUND,
        PLAYER,
        ENEMY,
        OBSTACLE,
        TRUNK,
        COIN,
        POWERUP;
    }
}
