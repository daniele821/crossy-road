package game.model.logic;

import java.util.Optional;
import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;

public class GameLogicImpl extends AbstractGameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        getGameWorld().getAllObjctes().forEach(obj -> ALGORITHMS.move(obj, elapsedTime));
    }

    @Override
    public void storeInputAction(final Consumer<GameWorld> action) {
        if (getStoredAction().isEmpty()) {
            setStoreAction(Optional.of(action));
        }
    }

    @Override
    public void executeInputAction() {
        getStoredAction().ifPresent(action -> action.accept(getGameWorld()));
    }

}
