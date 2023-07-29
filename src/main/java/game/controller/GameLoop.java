package game.controller;

import game.shared.ProgressiveTime;

public interface GameLoop {

    void processInput();

    void update(ProgressiveTime elapsedTime);

    void render();
}
