package game.controller.engine;

import game.model.entity.GameWorld;
import game.view.renderer.Window;

public interface GameEngine {

    void startThread(Window window, GameWorld gameWorld);

    void killThread();

    void pauseThread();

    void unpauseThread();
}
