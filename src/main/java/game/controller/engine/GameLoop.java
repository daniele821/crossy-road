package game.controller.engine;

import game.utility.ProgressiveTime;

public interface GameLoop {

    void processInput(ProgressiveTime elapsedTime);

    void update(ProgressiveTime elapsedTime);

    void render(ProgressiveTime elapsedTime);
}
