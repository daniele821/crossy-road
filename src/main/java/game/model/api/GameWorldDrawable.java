package game.model.api;

import java.util.List;

import game.common.Pair;
import game.common.Rectangle;

/** infos necessary to draw the game world. */
public interface GameWorldDrawable {
    /**
     * @return bounds of game world
     */
    Rectangle getWorldBounds();

    /**
     * @return bounds of object with which the camera will be centered
     */
    Rectangle getPositionToCenter();

    /**
     * @return position and path in memory of every object to render in the game
     */
    List<Pair<Rectangle, String>> getObjectsToDraw();
}
