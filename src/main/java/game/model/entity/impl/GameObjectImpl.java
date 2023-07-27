package game.model.entity.impl;

import game.model.entity.api.GameObject;
import game.model.entity.api.GameObjectType;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private GameObjectType objectType;
    private Rectangle position;
    private Vector2D speed;
    private String imageName;

    public GameObjectImpl(final GameObjectType objectType,
            final Rectangle position,
            final Vector2D speed,
            final String imageName) {
        this.objectType = objectType;
        this.position = position;
        this.speed = speed;
        this.imageName = imageName;
    }

    @Override
    public String getImageName() {
        return this.imageName;
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
    public void setImageName(final String imageName) {
        this.imageName = imageName;
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
    public void setObjectType(final GameObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public String toString() {
        return "GameObjectImpl [objectType=" + objectType + ", position=" + position + ", speed=" + speed
                + ", imageName=" + imageName + "]";
    }

}
