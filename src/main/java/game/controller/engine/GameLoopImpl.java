package game.controller.engine;

import game.model.entity.GameWorld;
import game.model.logic.GameLogicImpl;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    private final GameWorld gameWorld;
    private final Window window;

    public GameLoopImpl(final GameWorld gameWorld, final Window window) {
        this.gameWorld = gameWorld;
        this.window = window;
    }

    @Override
    public void processInput(final ProgressiveTime elapsedTime) {
        this.window.executeStoredActions(gameWorld);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        new GameLogicImpl(this.gameWorld).updateAll(elapsedTime);
    }

    @Override
    public void render(final ProgressiveTime elapsedTime) {
        this.window.update();
    }
}
