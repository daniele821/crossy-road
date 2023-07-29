package game.model.logic;

import game.model.GameWorld;

public class GameLogicImpl implements GameLogic {
    private final GameWorld gameWorld;

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }
}
