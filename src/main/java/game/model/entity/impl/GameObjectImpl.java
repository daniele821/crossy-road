package game.model.entity.impl;

import java.util.Optional;

import game.model.entity.api.GameObject;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private Rectangle position;
    private Optional<Vector2D> speed;
    private Optional<String> spriteFileName;

    public GameObjectImpl(final Rectangle initialPosition,
            final Optional<Vector2D> initialSpeed,
            final Optional<String> spriteFileName) {
        this.position = initialPosition;
        this.speed = initialSpeed;
        this.spriteFileName = spriteFileName;
    }

    @Override
    public Rectangle getPosition() {
        return this.position;
    }

    @Override
    public Optional<Vector2D> getSpeed() {
        return this.speed;
    }

    @Override
    public Optional<String> getSprite() {
        return this.spriteFileName;
    }

    @Override
    public void setPosition(final Rectangle newPosition) {
        this.position = newPosition;
    }

    @Override
    public void setSpeed(final Optional<Vector2D> newSpeed) {
        this.speed = newSpeed;
    }

    @Override
    public void setSprite(final Optional<String> newName) {
        this.spriteFileName = newName;
    }

    @Override
    public String toString() {
        return "AbstractGameObject (" + getClass().getSimpleName()
                + ") [position=" + position
                + ", speed=" + speed
                + ", spriteFileName=" + spriteFileName
                + "]";
    }

}
