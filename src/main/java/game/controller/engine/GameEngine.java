package game.controller.engine;

import game.model.GameWorld;

public interface GameEngine {

    void startThread();

    void killThread();

    void pauseThread();

    void unpauseThread();

    GameWorld getGameWorld();

    void setGameWorld(GameWorld gameWorld);
}
