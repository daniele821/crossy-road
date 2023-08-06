package game.model.logic;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.ProgressiveTime;
import game.utility.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void moveObject(final int objectId, final Vector2D movement) {
        if (objectId >= this.gameWorld.getObjects().size() || objectId < 0) {
            return;
        }
        final var object = this.gameWorld.modifyObjects().get(objectId);
        final var newPos = ALGORITHMS.add(object.getPosition(), movement);
        object.setPosition(newPos);

        // TODO collisions
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        final var objects = this.gameWorld.getObjects();
        for (int i = 0; i < objects.size(); i++) {
            final var object = objects.get(i);
            moveObject(i, ALGORITHMS.moveVector(object.getPosition(), object.getSpeed(), elapsedTime));
        }
    }

}
