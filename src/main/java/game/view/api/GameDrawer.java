package game.view.api;

import game.model.api.GameWorldDrawable;

/** rendered for the game world. */
public interface GameDrawer {

    /**
     * method to start renderer.
     * <p>
     * this means:
     * </p>
     * <p>
     * - making the window visible (GUI drawer)
     * </p>
     * <p>
     * - enabling writing on terminal (CLI/TUI drawer)
     * </p>
     */
    void startRenderer();

    /**
     * method to draw game world on the specific drawer.
     * 
     * @param world
     */
    void draw(GameWorldDrawable world);
}
