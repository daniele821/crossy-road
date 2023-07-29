package game.controller.engine;

import game.model.GameWorld;
import game.utility.AbstractGameWorldUser;
import game.utility.ProgressiveTime;

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
