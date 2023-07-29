package game.model.logic;

import game.model.GameWorld;

public class GameLogicObjectImpl implements GameLogicObject {
    private final GameWorld gameWorld;

    public GameLogicObjectImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public GameWorld getGameWorld() {
        return this.gameWorld;
    }

}
