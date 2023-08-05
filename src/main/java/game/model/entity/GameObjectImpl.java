package game.model.entity;

import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private GameObjectType objectType;
    private Rectangle position;
    private Vector2D speed;
    private boolean isPresent;

    public GameObjectImpl(final Rectangle pos, final Vector2D speed, final GameObjectType type,
            final boolean isPresent) {
        this.position = pos;
        this.speed = speed;
        this.objectType = type;
        this.isPresent = isPresent;
    }

    @Override
    public GameObject copy() {
        return new GameObjectImpl(this.position, this.speed, this.objectType, this.isPresent);
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
    public boolean isPresent() {
        return this.isPresent;
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
    public void setPresent(final boolean isPresent) {
        this.isPresent = isPresent;
    }

    @Override
    public String toString() {
        return "GameObjectImpl [objectType=" + objectType
                + ", position=" + position
                + ", speed=" + speed
                + ", isPresent=" + isPresent + "]";
    }

}
