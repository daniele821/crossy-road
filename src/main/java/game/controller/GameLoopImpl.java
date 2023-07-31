package game.controller;

import game.model.entity.GameWorld;
import game.shared.GameWorldUser;
import game.shared.ProgressiveTime;

public class GameLoopImpl extends GameWorldUser implements GameLoop {

    public GameLoopImpl(final GameWorld gameWorld) {
        super(gameWorld);
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

}
