package game.controller.engine;

import game.model.GameWorld;

public interface GameEngine {

    void startThread(GameWorld gameWorld);

    void killThread();

    void pauseThread();

    void unpauseThread();
}
