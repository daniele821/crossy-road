package game.model.logic;

import java.util.Optional;
import java.util.function.Consumer;

import game.model.entity.GameWorld;
import game.shared.GameWorldUser;

public abstract class AbstractGameLogic extends GameWorldUser implements GameLogic {
    private final CoinHandler coinHandler;
    private final PowerupHandler powerupHandler;
    private final CheckCollision checkCollision;
    private Optional<Consumer<GameWorld>> storedAction;

    protected AbstractGameLogic(final GameWorld gameWorld) {
        super(gameWorld);
        this.coinHandler = new CoinHandler(gameWorld);
        this.powerupHandler = new PowerupHandler(gameWorld);
        this.checkCollision = new CheckCollision(gameWorld);
        this.storedAction = Optional.empty();
    }

    protected CoinHandler getCoinHandler() {
        return this.coinHandler;
    }

    protected PowerupHandler getPowerupHandler() {
        return this.powerupHandler;
    }

    protected CheckCollision getCheckCollision() {
        return this.checkCollision;
    }

    protected Optional<Consumer<GameWorld>> getStoredAction() {
        return this.storedAction;
    }

    protected void setStoreAction(final Optional<Consumer<GameWorld>> storedAction) {
        this.storedAction = storedAction;
    }
}
