package game.controller;

import game.model.entity.GameWorld;

public interface GameEngine {

    void startThread(GameWorld gameWorld);

    void killThread();

    void pauseThread();

    void unpauseThread();
}
