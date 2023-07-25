package game.model.entity.api;

import java.util.Optional;

import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameObject {

    Rectangle getPosition();

    void setPosition(Rectangle newPosition);

    Optional<Vector2D> getSpeed();

    void setSpeed(Optional<Vector2D> newSpeed);

    /*
     * in the resource directory, there will be an image directory, which will contains 
     * all images (thus leaving to filesystem the burden of avoiding duplicate names)
     * 
     * the String will just be the file name (not file path!)
     */

    Optional<String> getSprite();

    void setSprite(Optional<String> newName);
}
