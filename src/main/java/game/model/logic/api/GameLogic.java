package game.model.logic.api;

import game.model.entity.api.GameWorld;

public interface GameLogic {

    GameWorld getGameWorld();

    void setGameWorld(GameWorld gameWorld);
}
