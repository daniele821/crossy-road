package game.utility;

import game.model.GameWorld;

public abstract class AbstractGameWorldUser {
    private final GameWorld gameWorld;

    public AbstractGameWorldUser(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    protected GameWorld getGameWorld() {
        return this.gameWorld;
    }

}
