package game.controller.engine;

import game.model.GameWorld;
import game.utility.ProgressiveTime;

public interface GameLoop {

    void processInput();

    void update(ProgressiveTime elapsedTime);

    void render();

    GameWorld getGameWorld();
}
