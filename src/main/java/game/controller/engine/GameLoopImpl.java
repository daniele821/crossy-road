package game.controller.engine;

import game.model.GameWorld;
import game.utility.ProgressiveTime;

public class GameLoopImpl implements GameLoop {
    private final GameWorld gameWorld;

    public GameLoopImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void processInput() {
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
    }

    @Override
    public void render() {
    }

    @Override
    public GameWorld getGameWorld() {
        return this.gameWorld;
    }

}
