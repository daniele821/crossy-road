package game.model.entity;

import static game.model.entity.GameObjectKind.*;

public enum GameObjectType {
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
