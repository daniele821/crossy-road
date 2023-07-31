package game.model.logic;

import game.model.entity.GameObject;
import game.model.world.GameWorld;
import game.shared.AbstractGameWorldUser;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

public class GameLogicImpl extends AbstractGameWorldUser implements GameLogic {

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
    }

    @Override
    public void movePlayer(final GameObject gameObject, final Vector2D direction) {
    }

}
