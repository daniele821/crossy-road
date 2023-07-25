package game.model.entity.impl;

import java.util.Optional;

import game.utility.Rectangle;
import game.utility.Vector2D;

public class MovableObstacleObject extends GameObjectImpl {

    public MovableObstacleObject(final Rectangle initialPosition,
            final Optional<Vector2D> initialSpeed,
            final Optional<String> spriteFileName) {
        super(initialPosition, initialSpeed, spriteFileName);
    }

}
