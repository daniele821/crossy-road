package game.model.entity;

import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameObject {
    Rectangle getPosition();

    void setPosition(Rectangle position);

    Vector2D getSpeed();

    void setSpeed(Vector2D speed);

    GameObjectType getObjectType();

    void setObjectType(GameObjectType objectType);
}
