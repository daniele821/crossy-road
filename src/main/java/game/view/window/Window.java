package game.view.window;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;

public interface Window {
    void update(ProgressiveTime elapsedTime);

    void executeStoredActions(ProgressiveTime elapsedTime, GameWorld gameWorld);
}
