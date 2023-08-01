package game.model.logic;

import java.util.Optional;
import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.ProgressiveTime;

public class GameLogicImpl extends AbstractGameLogic {

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
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
