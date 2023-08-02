package game.model.logic;

import java.util.Optional;
import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;
    private Optional<Consumer<GameWorld>> storedAction = Optional.empty();

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        this.gameWorld.getAllObjctes().forEach(obj -> obj.setPosition(ALGORITHMS.move(obj, elapsedTime)));
    }

    @Override
    public void storeInputAction(final Consumer<GameWorld> action) {
        if (this.storedAction.isEmpty()) {
            this.storedAction = Optional.ofNullable(action);
        }
    }

    @Override
    public void executeInputAction() {
        this.storedAction.ifPresent(action -> action.accept(this.gameWorld));
        this.storedAction = Optional.empty();
    }

}
