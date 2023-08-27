package game.model.world;

import game.common.Rectangle;
import game.common.Vector2D;
import game.model.api.resources.GameObjectKind;
import game.model.api.resources.GameObjectType;

public class GameObject {
    private GameObjectKind kind;
    private GameObjectType type;
    private Rectangle position;
    private Vector2D speed;

    public GameObject(final GameObjectKind kind, final GameObjectType type, final Rectangle position,
            final Vector2D speed) {
        this.kind = kind;
        this.type = type;
        this.position = position;
        this.speed = speed;
    }

    public GameObject(final GameObjectKind kind, final GameObjectType type, final Rectangle position) {
        this(kind, type, position, new Vector2D(0, 0));
    }

    // getters

    public GameObjectKind getKind() {
        return kind;
    }

    public GameObjectType getType() {
        return type;
    }

    public Rectangle getPosition() {
        return position;
    }

    public Vector2D getSpeed() {
        return speed;
    }

    // setters

    public void setKind(final GameObjectKind kind) {
        this.kind = kind;
    }

    public void setType(final GameObjectType type) {
        this.type = type;
    }

    public void setPosition(final Rectangle position) {
        this.position = position;
    }

    public void setSpeed(final Vector2D speed) {
        this.speed = speed;
    }
}
