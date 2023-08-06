package game.model.logic;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void moveObject(final int objectId, final Vector2D movement) {
        final var object = this.gameWorld.modifyObjects().get(objectId);
        final var newPos = ALGORITHMS.add(object.getPosition(), movement);
        object.setPosition(newPos);

        // TODO collisions
    }

}
