package game.model.logic.api;

import game.model.entity.api.GameWorld;

public class GameLogicImpl implements GameLogic {
    private GameWorld gameWorld;

    @Override
    public GameWorld getGameWorld() {
        return this.gameWorld;
    }

    @Override
    public void setGameWorld(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

}
