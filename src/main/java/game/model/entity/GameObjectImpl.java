package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public class GameObjectImpl implements GameObject {
    private Rectangle position;
    private Vector2D speed;
    private GameObjectType objectType;

    public static GameObject clone(final GameObject gameObject) {
        return new GameObjectImpl(gameObject.getPosition(), gameObject.getSpeed(), gameObject.getObjectType());
    }

    private GameObjectImpl(final Rectangle position, final Vector2D speed, final GameObjectType objectType) {
        this.position = Rectangle.clone(position);
        this.speed = Vector2D.clone(speed);
        this.objectType = objectType;
    }

    public GameObjectImpl(final Vector2D pos, final Vector2D speed, final GameObjectType type) {
        this(new Rectangle(pos.x, pos.y, type.lenX, type.lenY), speed, type);
    }

    @Override
    public GameObjectType getObjectType() {
        return this.objectType;
    }

    @Override
    public Rectangle getPosition() {
        return Rectangle.clone(this.position);
    }

    @Override
    public Vector2D getSpeed() {
        return Vector2D.clone(this.speed);
    }

    @Override
    public void setObjectType(final GameObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public void setPosition(final Rectangle position) {
        this.position = Rectangle.clone(position);
    }

    @Override
    public void setSpeed(final Vector2D speed) {
        this.speed = Vector2D.clone(speed);
    }

    @Override
    public String toString() {
        return "GameObjectImpl [position=" + position + ", speed=" + speed + ", objectType=" + objectType + "]";
    }

}
