package game.model.logic;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.ProgressiveTime;
import game.utility.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();

    @Override
    public void moveObject(final int objectId, final Vector2D movement, final GameWorld gameWorld) {
        if (objectId >= gameWorld.getObjects().size() || objectId < 0) {
            return;
        }
        final var object = gameWorld.modifyObjects().get(objectId);
        if (movement.equals(new Vector2D(0, 0)) || !object.isPresent()) {
            return;
        }
        final var newPos = ALGORITHMS.add(object.getPosition(), movement);
        object.setPosition(newPos);

        // TODO collisions
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        final var objects = gameWorld.getObjects();
        for (int i = 0; i < objects.size(); i++) {
            final var object = objects.get(i);
            final var move = ALGORITHMS.moveVector(object.getPosition(), object.getSpeed(), elapsedTime);
            moveObject(i, move, gameWorld);
        }
    }

}
