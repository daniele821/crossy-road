package game.controller.engine;

import game.shared.ProgressiveTime;

public interface GameLoop {

    void processInput();

    void update(ProgressiveTime elapsedTime);

    void render();
}
