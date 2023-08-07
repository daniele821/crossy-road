package game.controller.engine;

import game.model.entity.GameWorld;
import game.model.logic.GameLogicImpl;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    @Override
    public void processInput(final ProgressiveTime elapsedTime, final Window window, final GameWorld gameWorld) {
        window.executeStoredActions(gameWorld);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        new GameLogicImpl().updateAll(elapsedTime, gameWorld);
    }

    @Override
    public void render(final ProgressiveTime elapsedTime, final Window window) {
        window.update();
    }

    @Override
    public String toString() {
        return "GameLoopImpl []";
    }

}
