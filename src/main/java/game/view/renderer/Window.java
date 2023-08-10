package game.view.renderer;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;

public interface Window {

    void start();

    void update(ProgressiveTime elapsedTime);

    void executeStoredActions(ProgressiveTime elapsedTime, GameWorld gameWorld);

}
