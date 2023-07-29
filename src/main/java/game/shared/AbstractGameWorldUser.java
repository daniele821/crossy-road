package game.shared;

import game.model.GameWorld;

public class AbstractGameWorldUser {
    private final GameWorld gameWorld;

    protected AbstractGameWorldUser(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    protected GameWorld getGameWorld() {
        return this.gameWorld;
    }

}
