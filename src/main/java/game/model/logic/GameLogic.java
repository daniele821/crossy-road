package game.model.logic;

import game.utility.ProgressiveTime;
import game.utility.Vector2D;

public interface GameLogic {
    void moveObject(int objectId, Vector2D movement);

    void moveAll(ProgressiveTime elapsedTime);
}
