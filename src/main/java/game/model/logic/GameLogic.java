package game.model.logic;

import game.model.entity.GameObject;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

// handle coins, powerups, collisions inside the two methods!

public interface GameLogic {
    void updateAll(ProgressiveTime elapsedTime);

    void movePlayer(GameObject gameObject, Vector2D direction);

}
