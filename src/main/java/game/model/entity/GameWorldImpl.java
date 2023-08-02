package game.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.logic.GameLogic;
import game.model.logic.GameLogicImpl;
import game.shared.Rectangle;
import game.shared.Vector2D;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects;
    private final GameLogic gameLogic;
    private Rectangle gameWorldSize;
    private Vector2D backgroundCellSize;

    public GameWorldImpl(
            final List<GameObject> objects,
            final Rectangle gameWorldSize,
            final Vector2D backgroundCellSize) {
        this.gameWorldSize = gameWorldSize;
        this.backgroundCellSize = backgroundCellSize;
        this.objects = new ArrayList<>(objects);
        this.gameLogic = new GameLogicImpl(this);
    }

    @Override
    public List<GameObject> getAllObjctes() {
        return List.copyOf(this.objects);
    }

    @Override
    public void removeObject(final GameObject objectToRemove) {
        while (this.objects.contains(objectToRemove)) {
            this.objects.remove(objectToRemove);
        }
    }

    @Override
    public void addObject(final GameObject newObject) {
        Optional.ofNullable(newObject).ifPresent(this.objects::add);
    }

    @Override
    public Rectangle getGameWorldSize() {
        return this.gameWorldSize;
    }

    @Override
    public GameLogic getGameLogic() {
        return this.gameLogic;
    }

    @Override
    public Vector2D getBackgroundCellDimension() {
        return this.backgroundCellSize;
    }

    @Override
    public void setBackgroundCellDimension(final Vector2D backgroundCellSize) {
        this.backgroundCellSize = backgroundCellSize;
    }

    @Override
    public void setGameWorldSize(final Rectangle gameWorldSize) {
        this.gameWorldSize = gameWorldSize;
    }

    @Override
    public String toString() {
        return "GameWorldImpl [objects=" + objects
                + ", gameWorldSize=" + gameWorldSize
                + ", gameLogic=" + gameLogic
                + ", backgroundCellSize=" + backgroundCellSize + "]";
    }

}
