package game.controller;

import game.model.world.GameWorld;

public interface GameEngine {

    void startThread(GameWorld gameWorld);

    void killThread();

    void pauseThread();

    void unpauseThread();
}
