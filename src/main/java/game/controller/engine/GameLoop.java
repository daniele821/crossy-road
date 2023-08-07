package game.controller.engine;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public interface GameLoop {

    void processInput(ProgressiveTime elapsedTime, Window window, GameWorld gameWorld);

    void update(ProgressiveTime elapsedTime, GameWorld gameWorld);

    void render(ProgressiveTime elapsedTime, Window window);
}
