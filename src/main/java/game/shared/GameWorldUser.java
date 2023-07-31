package game.shared;

import game.model.world.GameWorld;

public class GameWorldUser {
    private final GameWorld gameWorld;

    protected GameWorldUser(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    protected GameWorld getGameWorld() {
        return this.gameWorld;
    }

}
