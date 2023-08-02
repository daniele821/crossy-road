package game.model.logic;

import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        this.gameWorld.getAllObjctes().forEach(obj -> obj.setPosition(ALGORITHMS.move(obj, elapsedTime)));
    }

    @Override
    public void executeInputAction() {

    }

}
