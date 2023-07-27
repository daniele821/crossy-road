package game.model.entity.impl;

import game.model.entity.api.GameObject;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private Rectangle position;
    private Vector2D speed;

    public GameObjectImpl(final Rectangle initialPosition, final Vector2D initialSpeed) {
        this.position = initialPosition;
        this.speed = initialSpeed;
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
    public void setPosition(final Rectangle newPosition) {
        this.position = newPosition;
    }

    @Override
    public void setSpeed(final Vector2D newSpeed) {
        this.speed = newSpeed;
    }

    @Override
    public String toString() {
        return "GameObjectImpl [position=" + position + ", speed=" + speed + "]";
    }

}
