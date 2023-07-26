package game.controller.engine.api;

import game.utility.ProgressiveTime;

public interface GameLoop {
    void processInput();

    void update(ProgressiveTime elapsedTime);

    void render();
}
