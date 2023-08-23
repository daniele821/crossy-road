package game.model.entity;

import java.util.Optional;

import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameObject {
    GameObject copy();

    Rectangle getPosition();

    void setPosition(Rectangle position);

    Vector2D getSpeed();

    void setSpeed(Vector2D speed);

    boolean isPresent();

    void setPresent(boolean isPresent);

    Optional<Vector2D> getWraparoundDelta();

    void setWraparoundDelta(Optional<Vector2D> delta);

    GameObjectType getObjectType();

    void setObjectType(GameObjectType objectType);
}
