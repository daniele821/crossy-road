package game.controller.engine;

import game.model.entity.GameWorld;
import game.shared.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    private final GameWorld gameWorld;
    private final Window window;

    public GameLoopImpl(final GameWorld gameWorld, final Window window) {
        this.gameWorld = gameWorld.copy();
        this.window = window;
    }

    @Override
    public void processInput() {
        // TODO
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        // TODO
    }

    @Override
    public void render() {
        this.window.update();
    }

    @Override
    public String toString() {
        return "GameLoopImpl [gameWorld=" + gameWorld + ", window=" + window + "]";
    }

}
