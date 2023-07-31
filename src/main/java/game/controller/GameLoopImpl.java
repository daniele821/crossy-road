package game.controller;

import game.model.world.GameWorld;
import game.shared.AbstractGameWorldUser;
import game.shared.ProgressiveTime;

public class GameLoopImpl extends AbstractGameWorldUser implements GameLoop {

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