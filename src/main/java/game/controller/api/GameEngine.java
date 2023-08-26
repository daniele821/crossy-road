package game.controller.api;

import game.model.api.GameWorld;
import game.view.api.GameDrawer;

/** game engine. */
public interface GameEngine {
    /** represents status of GameEngine. */
    enum GameEngineStatus {
        /** game is running. */
        RUNNING,
        /** game is paused. */
        PAUSED,
        /** game isn't running. */
        KILLED;
    }

    /**
     * change GameEngine status.
     * 
     * @param status
     */
    void changeStatus(GameEngineStatus status);

    /**
     * set the drawer which will render the game.
     * 
     * @param drawer
     */
    void setDrawer(GameDrawer drawer);

    /**
     * set the world which will be played.
     * 
     * @param world
     */
    void setWorld(GameWorld world);
}
