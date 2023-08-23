package game.model.logic;

import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;

public interface MovementLogic {

    Optional<Rectangle> wrapAround(GameWorld world, GameObject object, Rectangle newPos);

    boolean canMove(GameWorld world, int objectId, GameObject object, Rectangle newPos);

    void postMove(GameWorld world, int objectId, GameObject object, Rectangle newPos);
}
