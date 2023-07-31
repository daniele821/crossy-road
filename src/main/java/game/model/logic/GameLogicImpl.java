package game.model.logic;

import game.model.entity.GameObject;
import game.model.world.GameWorld;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

public class GameLogicImpl extends AbstractGameLogic {

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
    }

    @Override
    public void moveObject(final GameObject gameObject, final Vector2D direction) {
    }

}
