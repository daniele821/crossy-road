package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public interface GameObject {
    GameObject copy();

    Rectangle getPosition();

    void setPosition(Rectangle position);

    Vector2D getSpeed();

    void setSpeed(Vector2D speed);

    boolean isPresent();

    void setPresent(boolean isPresent);

    GameObjectType getObjectType();

    void setObjectType(GameObjectType objectType);
}
