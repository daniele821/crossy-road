package game.model.logic;

import game.model.GameWorld;

public class GameLogicObject {
    private final GameWorld gameWorld;

    protected GameLogicObject(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    protected GameWorld getGameWorld() {
        return this.gameWorld;
    }
}
