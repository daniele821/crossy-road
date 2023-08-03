package game.model.logic;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.shared.Algorithms;
import game.shared.ProgressiveTime;
import game.shared.Vector2D;

public class GameLogicImpl implements GameLogic {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final GameWorld gameWorld;
    private final InputHandler inputHandler;
    private final MoveObject moveObject;

    public GameLogicImpl(final GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.inputHandler = new InputHandler();
        this.moveObject = new MoveObject();
    }

    @Override
    public void updateAll(final ProgressiveTime elapsedTime) {
        this.gameWorld.getAllObjctes()
                .stream()
                .filter(obj -> !obj.getSpeed().equals(new Vector2D(0, 0)))
                .forEach(obj -> this.moveObject.moveObject(obj, ALGORITHMS.move(obj, elapsedTime)));

    }

    @Override
    public void executeInputAction() {
        this.inputHandler.getStoredAction()
                .forEach(pair -> {
                    final var obj = pair.getA();
                    final var move = pair.getB();
                    this.moveObject.moveObject(obj, ALGORITHMS.add(obj.getPosition(), move));
                });
    }

    @Override
    public void storeInputAction(final GameObject gameObject, final Vector2D moveVector) {
        this.inputHandler.storeAction(gameObject, moveVector);
    }

    @Override
    public String toString() {
        return "GameLogicImpl [gameWorld=" + gameWorld
                + ", inputHandler=" + inputHandler
                + ", moveObject=" + moveObject + "]";
    }

}
