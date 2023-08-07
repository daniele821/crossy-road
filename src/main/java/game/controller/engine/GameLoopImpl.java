package game.controller.engine;

import game.model.entity.GameWorld;
import game.model.logic.GameLogic;
import game.model.logic.GameLogicImpl;
import game.utility.ProgressiveTime;
import game.view.window.Window;

public class GameLoopImpl implements GameLoop {
    private final GameLogic gameLogic = new GameLogicImpl();

    @Override
    public void processInput(final ProgressiveTime elapsedTime, final Window window, final GameWorld gameWorld) {
        window.executeStoredActions(elapsedTime, gameWorld);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        this.gameLogic.updateAll(elapsedTime, gameWorld);
    }

    @Override
    public void render(final ProgressiveTime elapsedTime, final Window window) {
        window.update(elapsedTime);
    }

    @Override
    public String toString() {
        return "GameLoopImpl []";
    }

}
