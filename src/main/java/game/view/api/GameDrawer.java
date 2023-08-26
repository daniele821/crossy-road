package game.view.api;

import game.model.api.GameWorldDrawable;

/** rendered for the game world. */
public interface GameDrawer {
    /**
     * method to draw game world on the specific drawer.
     * 
     * @param world
     */
    void draw(GameWorldDrawable world);
}
