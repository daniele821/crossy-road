package game.model.entity;

public enum GameObjectKind {
    BACKGROUND("game/entity/background/"),
    PLAYER("game/entity/player/"),
    ENEMY("game/entity/enemy/"),
    OBSTACLE("game/entity/obstacle/"),
    TRUNK("game/entity/trunk/"),
    COIN("game/entity/coin/"),
    POWERUP("game/entity/powerup/");

    private final String dirPath;

    GameObjectKind(final String dirPath) {
        this.dirPath = dirPath;
    }

    public String getDirPath() {
        return this.dirPath;
    }
}