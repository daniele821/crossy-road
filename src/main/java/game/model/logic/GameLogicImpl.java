package game.model.logic;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

public class GameLogicImpl implements GameLogic {
    private final Algorithms algorithms = new Algorithms();
    private final GameWorld gameWorld;
    private final InputHandler inputHandler = new InputHandler();

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        this.gameWorld.getAllObjctes().forEach(obj -> obj.setPosition(this.algorithms.move(obj, elapsedTime)));

    }

    @Override
    public void executeInputAction() {

    }

    @Override
    public void storeInputAction(final GameObject gameObject, final Vector2D moveVector) {
        this.inputHandler.storeAction(gameObject, moveVector);
    }

}
