package game.controller.engine;

import game.utility.ProgressiveTime;

public interface GameLoop {

    void processInput(final ProgressiveTime elapsedTime);

    void update(ProgressiveTime elapsedTime);

    void render(final ProgressiveTime elapsedTime);
}
