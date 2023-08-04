package game.model.entity;

import static game.model.entity.GameObjectType.GameObjectKind.BACKGROUND;
import static game.model.entity.GameObjectType.GameObjectKind.COIN;
import static game.model.entity.GameObjectType.GameObjectKind.ENEMY;
import static game.model.entity.GameObjectType.GameObjectKind.OBSTACLE;
import static game.model.entity.GameObjectType.GameObjectKind.PLAYER;
import static game.model.entity.GameObjectType.GameObjectKind.POWERUP;

public enum GameObjectType {
    BAC_BIKE_LANE("game/entity/background/bike_lane.png", BACKGROUND, 16, 16, 0, 0),
    BAC_GRASS("game/entity/background/grass.png", BACKGROUND, 16, 16, 0, 0),
    BAC_RAIL("game/entity/background/rail.png", BACKGROUND, 16, 16, 0, 0),
    BAC_ROAD("game/entity/background/road.png", BACKGROUND, 16, 16, 0, 0),
    BAC_WATER("game/entity/background/water.png", BACKGROUND, 16, 16, 0, 0),
    COI_DEFAULT("game/entity/coin/coin.png", COIN, 10, 10, 3, 3),
    ENE_CAR_1_DX("game/entity/enemy/car_1_dx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_1_SX("game/entity/enemy/car_1_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_2_DX("game/entity/enemy/car_2_dx.png", ENEMY, 14, 9, 1, 3),
    ENE_CAR_2_SX("game/entity/enemy/car_2_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_3_DX("game/entity/enemy/car_3_dx.png", ENEMY, 14, 9, 1, 3),
    ENE_CAR_3_SX("game/entity/enemy/car_3_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_BIKE_DX("game/entity/enemy/bike_dx.png", ENEMY, 8, 7, 4, 3),
    ENE_BIKE_SX("game/entity/enemy/bike_sx.png", ENEMY, 8, 7, 4, 7),
    ENE_TRAIN_2_DX("game/entity/enemy/train_2_dx.png", ENEMY, 32, 13, 0, 1),
    ENE_TRAIN_2_SX("game/entity/enemy/train_2_sx.png", ENEMY, 32, 13, 0, 1),
    ENE_TRAIN_3_DX("game/entity/enemy/train_3_dx.png", ENEMY, 48, 13, 0, 1),
    ENE_TRAIN_3_SX("game/entity/enemy/train_3_sx.png", ENEMY, 48, 13, 0, 1),
    ENE_TRAIN_4_DX("game/entity/enemy/train_4_dx.png", ENEMY, 64, 13, 0, 1),
    ENE_TRAIN_4_SX("game/entity/enemy/train_4_sx.png", ENEMY, 64, 13, 0, 1),
    ENE_TRAIN("game/entity/enemy/train.png", ENEMY, 80, 13, 0, 1),
    OBS_BUSH("game/entity/obstacle/bush.png", OBSTACLE, 12, 12, 2, 2),
    OBS_TREE("game/entity/obstacle/tree.png", OBSTACLE, 13, 14, 2, 1),
    PLA_DEFAULT("game/entity/player/default.png", PLAYER, 10, 14, 3, 1),
    PLA_HULK("game/entity/player/hulk.png", PLAYER, 10, 14, 3, 1),
    PLA_SPONGEBOB("game/entity/player/spongebob.png", PLAYER, 12, 13, 2, 2),
    PLA_STEVE("game/entity/player/steve.png", PLAYER, 8, 14, 4, 1),
    PLA_SUPERMAN("game/entity/player/superman.png", PLAYER, 10, 14, 3, 1),
    PLA_THIEF("game/entity/player/thief.png", PLAYER, 10, 14, 3, 1),
    POW_IMMORTALITY("game/entity/powerup/immortality.png", POWERUP, 10, 10, 3, 3),
    POW_MAGNET("game/entity/powerup/magnet.png", POWERUP, 12, 10, 2, 3),
    POW_MULTIPLIER("game/entity/powerup/multiplier.png", POWERUP, 10, 10, 3, 3);

    public final String path;
    public final GameObjectKind kind;
    public final double lenX;
    public final double lenY;
    public final double deltaX;
    public final double deltaY;

    GameObjectType(final String path, final GameObjectKind kind, final double lenX, final double lenY,
            final double deltaX, final double deltaY) {
        this.path = path;
        this.kind = kind;
        this.lenX = lenX;
        this.lenY = lenY;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static enum GameObjectKind {
        BACKGROUND,
        PLAYER,
        ENEMY,
        OBSTACLE,
        TRUNK,
        COIN,
        POWERUP;
    }
}
