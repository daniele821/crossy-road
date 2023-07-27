package game.controller.engine.api;

import game.utility.ProgressiveTime;

/**
 * class GameEngine delegates the control over the game engine loop.
 * 
 * @see GameEngine
 */
public interface GameLoop {

    /** phase of the game loop which takes care of processing the input. */
    void processInput();

    /**
     * phase of the game loop which takes care of update the game world.
     * 
     * @param elapsedTime : time calculated by game engine
     */
    void update(ProgressiveTime elapsedTime);

    /** phase of the game loop which takes care of rendering the game world. */
    void render();
}
