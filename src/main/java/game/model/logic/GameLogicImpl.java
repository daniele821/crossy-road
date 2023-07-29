package game.model.logic;

import game.model.world.GameWorld;
import game.shared.AbstractGameWorldUser;

public class GameLogicImpl extends AbstractGameWorldUser implements GameLogic {

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

}
