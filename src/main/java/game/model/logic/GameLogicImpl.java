package game.model.logic;

import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.Pair;
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
        IntStream.range(0, objects.size())
                .mapToObj(i -> new Pair<>(i, ALGORITHMS.moveVector(objects.get(i), elapsedTime)))
                .forEach(pair -> moveObject(pair.getA(), pair.getB(), gameWorld));
    }

}
