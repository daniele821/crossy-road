package game.view.window;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;

public interface WindowInput {
    void executeStoredActions(ProgressiveTime elapsedTime, GameWorld gameWorld);

}
