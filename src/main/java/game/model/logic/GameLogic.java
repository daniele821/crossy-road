package game.model.logic;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;
import game.utility.Vector2D;

public interface GameLogic {
    void moveObject(int objectId, Vector2D movement, GameWorld gameWorld);

    void updateAll(ProgressiveTime elapsedTime, GameWorld gameWorld);
}
