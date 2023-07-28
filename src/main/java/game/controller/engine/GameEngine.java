package game.controller.engine;

public interface GameEngine {

    void startThread();

    void killThread();

    void pauseThread();

    void unpauseThread();
}
