package game.model.entity.impl;

import java.util.Optional;

import game.utility.Rectangle;

public class PlayerObject extends GameObjectImpl {

    public PlayerObject(final Rectangle initialPosition, final Optional<String> spriteFileName) {
        super(initialPosition, Optional.empty(), spriteFileName);
    }

}
