package game.controller;

public interface GameEngine {

    void startThread(GameLoop gameLoop);

    void killThread();

    void pauseThread();

    void unpauseThread();
}
