package game.controller.engine;

import game.common.ProgressiveTime;

public interface GameLoop {

    void processInput();

    void update(ProgressiveTime elapsedTime);

    void render();
}
