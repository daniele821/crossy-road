package game.controller.engine.api;

/*
 * to create only once, and then start / kill thread whenever app switch to game scene
 */

public interface GameEngine {
    void startThread();

    void killThread();

    void pauseThread();

    void unpauseThread();
}
