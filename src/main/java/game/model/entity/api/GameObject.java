package game.model.entity.api;

import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameObject {
    Rectangle getPosition();

    void setPosition(Rectangle position);

    Vector2D getSpeed();

    void setSpeed(Vector2D speed);

    String getImageName();

    void setImageName(String imageName);

    GameObjectType getObjectType();

    void setObjectType(GameObjectType objectType);
}
