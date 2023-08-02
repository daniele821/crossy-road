package game.controller.engine;

import game.model.entity.GameWorld;
import game.shared.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    private final GameWorld gameWorld;
    private final Window window;

    public GameLoopImpl(final GameWorld gameWorld, final Window window) {
        this.gameWorld = gameWorld;
        this.window = window;
    }

    @Override
    public void processInput() {
        this.gameWorld.getGameLogic().executeInputAction();
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        this.gameWorld.getGameLogic().updateAll(elapsedTime);
    }

    @Override
    public void render() {
        this.window.update();
    }

}
