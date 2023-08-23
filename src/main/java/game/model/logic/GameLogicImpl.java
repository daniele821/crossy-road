package game.model.logic;

import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldUtil;
import game.model.entity.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Pair;
import game.utility.ProgressiveTime;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class GameLogicImpl implements GameLogic {
    private final Algorithms algorithms = new Algorithms();
    private final GameWorldUtil worldUtil = new GameWorldUtilImpl();
    private final MovementLogic movementLogic = new MovementLogicImpl();

    @Override
    public void moveObject(final int objectId, final Vector2D movement, final GameWorld gameWorld) {
        final Optional<GameObject> objectOpt = worldUtil.getPresentObject(objectId, gameWorld);
        if (objectOpt.isEmpty() || movement.equals(new Vector2D(0, 0))) {
            return;
        }
        final GameObject object = objectOpt.get();
        final Rectangle newPos = algorithms.add(object.getPosition(), movement);

        if (this.movementLogic.canMove(gameWorld, objectId, object, newPos)) {
            final Optional<Rectangle> newWrapPos = this.movementLogic.wrapAround(gameWorld, object, newPos);
            if (newWrapPos.isEmpty() || this.movementLogic.canMove(gameWorld, objectId, object, newPos)) {
                object.setPosition(newWrapPos.orElse(newPos));
                this.movementLogic.postMove(gameWorld, objectId, object, newPos);
            }
        }

    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        worldUtil.getPresentObjectsWithId(gameWorld)
                .stream()
                .map(pair -> new Pair<>(pair.getA(), algorithms.moveVector(pair.getB(), elapsedTime)))
                .forEach(pair -> moveObject(pair.getA(), pair.getB(), gameWorld));
    }

}
