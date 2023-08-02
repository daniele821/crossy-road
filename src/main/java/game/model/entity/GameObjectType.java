package game.model.entity;

import static game.model.entity.GameObjectKind.BACKGROUND;
import static game.model.entity.GameObjectKind.COIN;
import static game.model.entity.GameObjectKind.ENEMY;
import static game.model.entity.GameObjectKind.OBSTACLE;
import static game.model.entity.GameObjectKind.PLAYER;
import static game.model.entity.GameObjectKind.POWERUP;

public enum GameObjectType {
    BAC_BIKE_LANE("bike_lane.png", BACKGROUND),
    BAC_GRASS("grass.png", BACKGROUND),
    BAC_RAIL("rail.png", BACKGROUND),
    BAC_ROAD("road.png", BACKGROUND),
    BAC_WATER("water.png", BACKGROUND),
    COI_COIN("coin.png", COIN),
    ENE_CAR_1_DX("car_1_dx", ENEMY),
    ENE_CAR_1_SX("car_1_sx", ENEMY),
    ENE_CAR_2_DX("car_2_dx", ENEMY),
    ENE_CAR_2_SX("car_2_sx", ENEMY),
    ENE_CAR_3_DX("car_3_dx", ENEMY),
    ENE_CAR_3_SX("car_3_sx", ENEMY),
    ENE_BIKE_DX("bike_dx", ENEMY),
    ENE_BIKE_SX("bike_sx", ENEMY),
    ENE_TRAIN_2_DX("train_2_dx.png", ENEMY),
    ENE_TRAIN_2_SX("train_2_sx.png", ENEMY),
    ENE_TRAIN_3_DX("train_3_dx.png", ENEMY),
    ENE_TRAIN_3_SX("train_3_sx.png", ENEMY),
    ENE_TRAIN_4_DX("train_4_dx.png", ENEMY),
    ENE_TRAIN_4_SX("train_4_sx.png", ENEMY),
    ENE_TRAIN("train.png", ENEMY),
    OBS_BUSH("bush.png", OBSTACLE),
    OBS_TREE("tree.png", OBSTACLE),
    PLA_DEFAULT("default.png", PLAYER),
    PLA_HULK("hulk.png", PLAYER),
    PLA_SPONGEBOB("spongebob.png", PLAYER),
    PLA_STEVE("steve.png", PLAYER),
    PLA_SUPERMAN("superman.png", PLAYER),
    PLA_THIEF("thief.png", PLAYER),
    POW_IMMORTALITY("immortality.png", POWERUP),
    POW_MAGNET("magnet.png", POWERUP),
    POW_MULTIPLIER("multiplier.png", POWERUP);

    private final String imagePath;
    private final GameObjectKind objectKind;

    GameObjectType(final String imagePath, final GameObjectKind objectKind) {
        this.imagePath = objectKind.getDirPath() + imagePath;
        this.objectKind = objectKind;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public GameObjectKind getObjectKind() {
        return this.objectKind;
    }
}
