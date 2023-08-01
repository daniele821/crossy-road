package game.model.logic;

import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.ProgressiveTime;

// handle coins, powerups, collisions inside the two methods!

public interface GameLogic {
    void updateAll(ProgressiveTime elapsedTime);

    void storeInputAction(Consumer<GameWorld> action);

    void executeInputAction();
}
