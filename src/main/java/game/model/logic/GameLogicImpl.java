package game.model.logic;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;
    private final InputHandler inputHandler = new InputHandler();

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        this.gameWorld.getAllObjctes()
                .stream()
                .filter(obj -> !obj.getSpeed().equals(new Vector2D(0, 0)))
                .forEach(obj -> {
                    obj.setPosition(ALGORITHMS.move(obj, elapsedTime));
                });

    }

    @Override
    public void executeInputAction() {
        this.inputHandler.getStoredAction().forEach(pair -> {
            pair.getA().setPosition(ALGORITHMS.add(pair.getA().getPosition(), pair.getB()));
        });
    }

    @Override
    public void storeInputAction(final GameObject gameObject, final Vector2D moveVector) {
        this.inputHandler.storeAction(gameObject, moveVector);
    }

    // TODO add: toString

}
