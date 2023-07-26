package game.controller.engine.api;

public interface GameEngine {
    void startThread();

    void killThread();

    void pauseThread();

    void unpauseThread();
}
