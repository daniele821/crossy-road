package game.controller;

import game.model.entity.GameWorld;
import game.shared.GameWorldUser;
import game.shared.ProgressiveTime;
import game.view.Window;

public class GameLoopImpl extends GameWorldUser implements GameLoop {
    private final Window window;

    public GameLoopImpl(final GameWorld gameWorld, final Window window) {
        super(gameWorld);
        this.window = window;
    }

    @Override
    public void processInput() {
        getGameWorld().getGameLogic().executeInputAction();
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        getGameWorld().getGameLogic().updateAll(elapsedTime);
    }

    @Override
    public void render() {
        this.window.update();
    }

}
