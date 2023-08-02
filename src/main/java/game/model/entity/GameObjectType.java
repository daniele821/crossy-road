package game.model.entity;

import static game.model.entity.GameObjectKind.BACKGROUND;
import static game.model.entity.GameObjectKind.COIN;
import static game.model.entity.GameObjectKind.ENEMY;
import static game.model.entity.GameObjectKind.OBSTACLE;
import static game.model.entity.GameObjectKind.PLAYER;
import static game.model.entity.GameObjectKind.POWERUP;

public enum GameObjectType {
    BAC_BIKE_LANE("bike_lane.png", BACKGROUND, 16, 16),
    BAC_GRASS("grass.png", BACKGROUND, 16, 16),
    BAC_RAIL("rail.png", BACKGROUND, 16, 16),
    BAC_ROAD("road.png", BACKGROUND, 16, 16),
    BAC_WATER("water.png", BACKGROUND, 16, 16),
    COI_COIN("coin.png", COIN, 10, 10),
    ENE_CAR_1_DX("car_1_dx.png", ENEMY, 14, 8),
    ENE_CAR_1_SX("car_1_sx.png", ENEMY, 14, 8),
    ENE_CAR_2_DX("car_2_dx.png", ENEMY, 14, 9),
    ENE_CAR_2_SX("car_2_sx.png", ENEMY, 14, 8),
    ENE_CAR_3_DX("car_3_dx.png", ENEMY, 14, 9),
    ENE_CAR_3_SX("car_3_sx.png", ENEMY, 14, 8),
    ENE_BIKE_DX("bike_dx.png", ENEMY, 8, 7),
    ENE_BIKE_SX("bike_sx.png", ENEMY, 8, 7),
    ENE_TRAIN_2_DX("train_2_dx.png", ENEMY, 32, 13),
    ENE_TRAIN_2_SX("train_2_sx.png", ENEMY, 32, 13),
    ENE_TRAIN_3_DX("train_3_dx.png", ENEMY, 48, 13),
    ENE_TRAIN_3_SX("train_3_sx.png", ENEMY, 48, 13),
    ENE_TRAIN_4_DX("train_4_dx.png", ENEMY, 64, 13),
    ENE_TRAIN_4_SX("train_4_sx.png", ENEMY, 64, 13),
    ENE_TRAIN("train.png", ENEMY, 80, 13),
    OBS_BUSH("bush.png", OBSTACLE, 12, 12),
    OBS_TREE("tree.png", OBSTACLE, 13, 14),
    PLA_DEFAULT("default.png", PLAYER, 10, 14),
    PLA_HULK("hulk.png", PLAYER, 10, 14),
    PLA_SPONGEBOB("spongebob.png", PLAYER, 12, 13),
    PLA_STEVE("steve.png", PLAYER, 8, 14),
    PLA_SUPERMAN("superman.png", PLAYER, 10, 14),
    PLA_THIEF("thief.png", PLAYER, 10, 14),
    POW_IMMORTALITY("immortality.png", POWERUP, 10, 10),
    POW_MAGNET("magnet.png", POWERUP, 12, 10),
    POW_MULTIPLIER("multiplier.png", POWERUP, 10, 10);

    private final String imagePath;
    private final GameObjectKind objectKind;
    private final double imageLenX;
    private final double imageLenY;

    GameObjectType(
            final String imagePath,
            final GameObjectKind objectKind,
            final double imageLenX,
            final double imageLenY) {
        this.imagePath = objectKind.getDirPath() + imagePath;
        this.objectKind = objectKind;
        this.imageLenX = imageLenX;
        this.imageLenY = imageLenY;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public GameObjectKind getObjectKind() {
        return this.objectKind;
    }

    public double getImageLenX() {
        return this.imageLenX;
    }

    public double getImageLenY() {
        return this.imageLenY;
    }
}
