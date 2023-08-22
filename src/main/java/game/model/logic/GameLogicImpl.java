package game.model.logic;

import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Pair;
import game.utility.ProgressiveTime;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();

    @Override
    public void moveObject(final int objectId, final Vector2D movement, final GameWorld gameWorld) {
        final Optional<GameObject> objectOpt = WORLD_UTIL.getPresentObject(objectId, gameWorld);
        if (objectOpt.isEmpty() || movement.equals(new Vector2D(0, 0))) {
            return;
        }
        final GameObject object = objectOpt.get();
        final Rectangle newPos = ALGORITHMS.add(object.getPosition(), movement);
        object.setPosition(newPos);

        // TODO collisions
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        WORLD_UTIL.getPresentObjectsWithId(gameWorld)
                .stream()
                .map(pair -> new Pair<>(pair.getA(), ALGORITHMS.moveVector(pair.getB(), elapsedTime)))
                .forEach(pair -> moveObject(pair.getA(), pair.getB(), gameWorld));
    }

}
