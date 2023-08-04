package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public class GameObjectImpl implements GameObject {
    private Rectangle position;
    private Vector2D speed;
    private GameObjectType objectType;

    private GameObjectImpl(final Rectangle position, final Vector2D speed, final GameObjectType objectType) {
        this.position = position;
        this.speed = speed;
        this.objectType = objectType;
    }

    public GameObjectImpl(final Vector2D pos, final Vector2D speed, final GameObjectType type) {
        this(new Rectangle(pos.getX(), pos.getY(), type.lenX, type.lenY), speed, type);
    }

    @Override
    public GameObject copy() {
        return new GameObjectImpl(this.position, this.speed, this.objectType);
    }

    @Override
    public GameObjectType getObjectType() {
        return this.objectType;
    }

    @Override
    public Rectangle getPosition() {
        return this.position;
    }

    @Override
    public Vector2D getSpeed() {
        return this.speed;
    }

    @Override
    public void setObjectType(final GameObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public void setPosition(final Rectangle position) {
        this.position = position;
    }

    @Override
    public void setSpeed(final Vector2D speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "GameObjectImpl [position=" + position + ", speed=" + speed + ", objectType=" + objectType + "]";
    }

}
