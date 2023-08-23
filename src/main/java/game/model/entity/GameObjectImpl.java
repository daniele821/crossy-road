package game.model.entity;

import java.util.Optional;

import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameObjectImpl implements GameObject {
    private Optional<Vector2D> wraparound;
    private GameObjectType objectType;
    private Rectangle position;
    private Vector2D speed;
    private boolean isPresent;

    public GameObjectImpl(final Rectangle pos, final Vector2D speed, final GameObjectType type,
            final boolean isPresent, final Optional<Vector2D> wraparound) {
        this.position = pos;
        this.speed = speed;
        this.objectType = type;
        this.isPresent = isPresent;
        this.wraparound = wraparound;
    }

    @Override
    public GameObject copy() {
        return new GameObjectImpl(this.position, this.speed, this.objectType, this.isPresent, this.wraparound);
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
    public Optional<Vector2D> getWraparoundDelta() {
        return this.wraparound;
    }

    @Override
    public void setWraparoundDelta(final Optional<Vector2D> delta) {
        this.wraparound = delta;
    }

}
