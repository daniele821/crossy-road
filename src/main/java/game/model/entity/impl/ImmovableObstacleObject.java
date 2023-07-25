package game.model.entity.impl;

import java.util.Optional;

import game.utility.Rectangle;

public class ImmovableObstacleObject extends GameObjectImpl {

    public ImmovableObstacleObject(final Rectangle initialPosition, final Optional<String> spriteFileName) {
        super(initialPosition, Optional.empty(), spriteFileName);
    }

}
