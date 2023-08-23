package game.model.entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import game.model.entity.GameObjectType.GameObjectKind;
import game.utility.Algorithms;
import game.utility.Pair;
import game.utility.Vector2D;

public class GameWorldUtilImpl implements GameWorldUtil {
    private final Algorithms algorithms = new Algorithms();

    @Override
    public List<Pair<Integer, GameObject>> getObjectsWithId(final GameWorld world) {
        return IntStream.range(0, getSize(world)).mapToObj(i -> new Pair<>(i, world.getObjects().get(i))).toList();
    }

    @Override
    public List<Pair<Integer, GameObject>> getPresentObjectsWithId(final GameWorld world) {
        return getObjectsWithId(world).stream().filter(pair -> pair.getB().isPresent()).toList();
    }

    @Override
    public List<GameObject> getObjects(final GameWorld world) {
        return world.getObjects();
    }

    @Override
    public List<GameObject> getPresentObjects(final GameWorld world) {
        return getObjects(world).stream().filter(GameObject::isPresent).toList();
    }

    @Override
    public Optional<GameObject> getObject(final int objectId, final GameWorld world) {
        if (!isObjectIdValid(objectId, world)) {
            return Optional.empty();
        }
        return Optional.ofNullable(world.getObjects().get(objectId));
    }

    @Override
    public Optional<GameObject> getPresentObject(final int objectId, final GameWorld world) {
        return getObject(objectId, world).filter(GameObject::isPresent);
    }

    @Override
    public int getSize(final GameWorld world) {
        return world.getObjects().size();
    }

    @Override
    public boolean isObjectIdValid(final int objectId, final GameWorld world) {
        return objectId >= 0 && objectId < getSize(world);
    }

    @Override
    public List<Pair<Integer, GameObject>> filterByKind(final GameWorld world, final GameObjectKind kind) {
        return getObjectsWithId(world).stream().filter(pair -> pair.getB().getObjectType().getKind() == kind).toList();
    }

    @Override
    public List<Pair<Integer, GameObject>> filterByKindPresent(final GameWorld world, final GameObjectKind kind) {
        return filterByKind(world, kind).stream().filter(i -> i.getB().isPresent()).toList();
    }

    @Override
    public Vector2D convertCellToPixel(final Vector2D cellPos, final GameWorldInfo info, final GameObjectType type) {
        final Vector2D cellSize = info.getCellSize();
        final Vector2D position = this.algorithms.multiplyMembers(cellSize, cellPos);
        final double x = type.getDeltaX() + position.getX() + info.getWorldBounds().getX();
        final double y = type.getDeltaY() + position.getY() + info.getWorldBounds().getY();
        return new Vector2D(x, y);
    }

    @Override
    public Vector2D convertPixelToCell(final Vector2D cellPos, final GameWorldInfo info, final GameObjectType type) {
        final var worldSize = info.getWorldBounds();
        final double x = (cellPos.getX() - worldSize.getX() - type.getDeltaX()) / info.getCellSize().getX();
        final double y = (cellPos.getY() - worldSize.getY() - type.getDeltaY()) / info.getCellSize().getX();
        return new Vector2D(Math.round(x), Math.round(y));
    }

    @Override
    public Vector2D roundPosToCellPos(final Vector2D pos, final GameWorldInfo info, final GameObjectType type) {
        return convertCellToPixel(convertPixelToCell(pos, info, type), info, type);
    }

}
