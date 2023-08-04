package game.model.entity;

import static game.model.entity.GameObjectType.GameObjectKind.BACKGROUND;
import static game.model.entity.GameObjectType.GameObjectKind.COIN;
import static game.model.entity.GameObjectType.GameObjectKind.ENEMY;
import static game.model.entity.GameObjectType.GameObjectKind.OBSTACLE;
import static game.model.entity.GameObjectType.GameObjectKind.PLAYER;
import static game.model.entity.GameObjectType.GameObjectKind.POWERUP;

public enum GameObjectType {
    BAC_BIKE_LANE("background/bike_lane.png", BACKGROUND, 16, 16, 0, 0),
    BAC_GRASS("background/grass.png", BACKGROUND, 16, 16, 0, 0),
    BAC_RAIL("background/rail.png", BACKGROUND, 16, 16, 0, 0),
    BAC_ROAD("background/road.png", BACKGROUND, 16, 16, 0, 0),
    BAC_WATER("background/water.png", BACKGROUND, 16, 16, 0, 0),
    COI_DEFAULT("coin/coin.png", COIN, 10, 10, 3, 3),
    ENE_CAR_1_DX("enemy/car_1_dx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_1_SX("enemy/car_1_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_2_DX("enemy/car_2_dx.png", ENEMY, 14, 9, 1, 3),
    ENE_CAR_2_SX("enemy/car_2_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_CAR_3_DX("enemy/car_3_dx.png", ENEMY, 14, 9, 1, 3),
    ENE_CAR_3_SX("enemy/car_3_sx.png", ENEMY, 14, 8, 1, 4),
    ENE_BIKE_DX("enemy/bike_dx.png", ENEMY, 8, 7, 4, 3),
    ENE_BIKE_SX("enemy/bike_sx.png", ENEMY, 8, 7, 4, 7),
    ENE_TRAIN_2_DX("enemy/train_2_dx.png", ENEMY, 32, 13, 0, 1),
    ENE_TRAIN_2_SX("enemy/train_2_sx.png", ENEMY, 32, 13, 0, 1),
    ENE_TRAIN_3_DX("enemy/train_3_dx.png", ENEMY, 48, 13, 0, 1),
    ENE_TRAIN_3_SX("enemy/train_3_sx.png", ENEMY, 48, 13, 0, 1),
    ENE_TRAIN_4_DX("enemy/train_4_dx.png", ENEMY, 64, 13, 0, 1),
    ENE_TRAIN_4_SX("enemy/train_4_sx.png", ENEMY, 64, 13, 0, 1),
    ENE_TRAIN("enemy/train.png", ENEMY, 80, 13, 0, 1),
    OBS_BUSH("obstacle/bush.png", OBSTACLE, 12, 12, 2, 2),
    OBS_TREE("obstacle/tree.png", OBSTACLE, 13, 14, 2, 1),
    PLA_DEFAULT("player/default.png", PLAYER, 10, 14, 3, 1),
    PLA_HULK("player/hulk.png", PLAYER, 10, 14, 3, 1),
    PLA_SPONGEBOB("player/spongebob.png", PLAYER, 12, 13, 2, 2),
    PLA_STEVE("player/steve.png", PLAYER, 8, 14, 4, 1),
    PLA_SUPERMAN("player/superman.png", PLAYER, 10, 14, 3, 1),
    PLA_THIEF("player/thief.png", PLAYER, 10, 14, 3, 1),
    POW_IMMORTALITY("powerup/immortality.png", POWERUP, 10, 10, 3, 3),
    POW_MAGNET("powerup/magnet.png", POWERUP, 12, 10, 2, 3),
    POW_MULTIPLIER("powerup/multiplier.png", POWERUP, 10, 10, 3, 3);

    public static final String ENTITY_DIR = "game/entity/";
    public final String path;
    public final GameObjectKind kind;
    public final double lenX;
    public final double lenY;
    public final double deltaX;
    public final double deltaY;

    GameObjectType(final String path, final GameObjectKind kind, final double lenX, final double lenY,
            final double deltaX, final double deltaY) {
        this.path = ENTITY_DIR + path;
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
