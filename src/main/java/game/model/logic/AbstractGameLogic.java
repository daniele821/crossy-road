package game.model.logic;

import game.model.entity.GameWorld;
import game.shared.GameWorldUser;

public abstract class AbstractGameLogic extends GameWorldUser implements GameLogic {
    private final CoinHandler coinHandler;
    private final PowerupHandler powerupHandler;
    private final CheckCollision checkCollision;

    protected AbstractGameLogic(final GameWorld gameWorld) {
        super(gameWorld);
        this.coinHandler = new CoinHandler(gameWorld);
        this.powerupHandler = new PowerupHandler(gameWorld);
        this.checkCollision = new CheckCollision(gameWorld);
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

}
