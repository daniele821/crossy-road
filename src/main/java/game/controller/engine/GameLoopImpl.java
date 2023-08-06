package game.controller.engine;

import game.model.logic.GameLogic;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    private final GameLogic gameLogic;
    private final Window window;

    public GameLoopImpl(final GameLogic gameLogic, final Window window) {
        this.gameLogic = gameLogic;
        this.window = window;
    }

    @Override
    public void processInput(final ProgressiveTime elapsedTime) {
        // TODO
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        this.gameLogic.updateAll(elapsedTime);
    }

    @Override
    public void render(final ProgressiveTime elapsedTime) {
        this.window.update();
    }
}
