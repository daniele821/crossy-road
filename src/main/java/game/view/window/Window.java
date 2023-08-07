package game.view.window;

import game.model.entity.GameWorld;

public interface Window {
    void update();

    void executeStoredActions(GameWorld gameWorld);
}
