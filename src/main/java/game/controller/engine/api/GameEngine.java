package game.controller.engine.api;

/**
 * class to control the game engine thread.
 * 
 * <p>
 * one single game engine object should be created for the whole
 * duration of the application usage
 * <p/>
 */
public interface GameEngine {

    /** start game engine thread if not already running. */
    void startThread();

    /** kill game engine if already running. */
    void killThread();

    /** pause game engine thread if it's currently running. */
    void pauseThread();

    /** unpause game engine thread if it's currently running. */
    void unpauseThread();
}
