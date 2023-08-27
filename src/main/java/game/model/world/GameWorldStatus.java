package game.model.world;

import java.util.ArrayList;
import java.util.List;

import game.common.Pair;
import game.common.Rectangle;
import game.common.Vector2D;
import game.common.util.Vectors2D;

public class GameWorldStatus {
    private final Vector2D cellSize;
    private final Vector2D worldSizeInCells;
    private final GameObject player;
    private final List<GameObject> objects = new ArrayList<>();
    private final List<GameObject> removedObjects = new ArrayList<>();
    private final List<Pair<Rectangle, String>> objectPath = new ArrayList<>();

    // constructors

    public GameWorldStatus(final Vector2D cellSize, final Vector2D worldSizeInCells, final GameObject player,
            final List<GameObject> objects, final List<GameObject> removedObjects) {
        this.cellSize = cellSize;
        this.worldSizeInCells = worldSizeInCells;
        this.player = player;
        this.objects.addAll(objects);
        this.removedObjects.addAll(removedObjects);
        updateObjectPath();
    }

    // private methods

    private void updateObjectPath() {
        objectPath.clear();
        objectPath.addAll(objects.stream().map(obj -> new Pair<>(obj.getPosition(), obj.getType().getPath())).toList());
    }

    // getters

    public Vector2D getCellSize() {
        return cellSize;
    }

    public Vector2D getWorldSizeInCells() {
        return worldSizeInCells;
    }

    public GameObject getPlayer() {
        return player;
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public List<GameObject> getRemovedObjects() {
        return removedObjects;
    }

    public List<Pair<Rectangle, String>> getObjectsPath() {
        return objectPath;
    }

    // setters

    public void addObject(final GameObject object) {
        if (removedObjects.remove(object)) {
            objects.add(object);
        }
        updateObjectPath();
    }

    public void removeObject(final GameObject object) {
        if (objects.remove(object)) {
            removedObjects.add(object);
        }
        updateObjectPath();
    }

    // calculations

    public Rectangle getWorldBounds() {
        return new Rectangle(0, 0, Vectors2D.multiplyMembers(worldSizeInCells, cellSize));
    }

}
