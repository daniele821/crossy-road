package game.model.logic;

import java.util.Optional;
import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.GameWorldUser;
import game.shared.ProgressiveTime;

public class GameLogicImpl extends GameWorldUser implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    // private final CoinHandler coinHandler = new CoinHandler(getGameWorld());
    // private final PowerupHandler powerupHandler = new PowerupHandler(getGameWorld());
    // private final CheckCollision checkCollision = new CheckCollision(getGameWorld());
    private Optional<Consumer<GameWorld>> storedAction = Optional.empty();

    public GameLogicImpl(final GameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        getGameWorld().getAllObjctes().forEach(obj -> obj.setPosition(ALGORITHMS.move(obj, elapsedTime)));
    }

    @Override
    public void storeInputAction(final Consumer<GameWorld> action) {
        if (this.storedAction.isEmpty()) {
            this.storedAction = Optional.ofNullable(action);
        }
    }

    @Override
    public void executeInputAction() {
        this.storedAction.ifPresent(action -> action.accept(getGameWorld()));
        this.storedAction = Optional.empty();
    }

}
