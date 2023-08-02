package game.model.logic;

import game.shared.ProgressiveTime;

// handle coins, powerups, collisions inside the two methods!

public interface GameLogic {
    void updateAll(ProgressiveTime elapsedTime);

    void executeInputAction();
}
