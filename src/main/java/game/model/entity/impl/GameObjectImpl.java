package game.model.entity.impl;

import game.model.entity.api.GameObject;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private Rectangle position;
    private Vector2D speed;
    private GameObjectType objectType;

    public GameObjectImpl(final Rectangle position, final Vector2D speed,
            final GameObjectType objectType) {
        this.position = position;
        this.speed = speed;
        this.objectType = objectType;
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

}
