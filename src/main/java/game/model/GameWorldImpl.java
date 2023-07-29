package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.logic.GameLogic;
import game.model.logic.GameLogicImpl;
import game.utility.Rectangle;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects;
    private Rectangle gameWorldSize;
    private GameLogic gameLogic;

    public GameWorldImpl(final List<GameObject> objects, final Rectangle gameWorldSize) {
        this.gameWorldSize = gameWorldSize;
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
    public void setGameWorldSize(final Rectangle gameWorldSize) {
        this.gameWorldSize = gameWorldSize;
    }

    @Override
    public GameLogic getGameLogic() {
        return this.gameLogic;
    }

    @Override
    public void setGameLogic(final GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @Override
    public String toString() {
        return "GameWorldImpl [objects=" + objects
                + ", gameWorldSize=" + gameWorldSize
                + ", gameLogic=" + gameLogic + "]";
    }

}
