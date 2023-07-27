package game.model.entity.api;

import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameObject {
    Rectangle getPosition();

    void setPosition(Rectangle newPosition);

    Vector2D getSpeed();

    void setSpeed(Vector2D newSpeed);
}
