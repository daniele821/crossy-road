package game.model.entity.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameObjectType.GameObjectKind;
import game.model.entity.GameWorld;
import game.utility.Pair;

public class GameWorldUtilImpl implements GameWorldUtil {

    @Override
    public List<Pair<Integer, GameObject>> getObjectsWithId(final GameWorld world) {
        return IntStream.range(0, getSize(world))
                .mapToObj(i -> new Pair<>(i, world.getObjects().get(i)))
                .toList();
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
    public Optional<GameObject> modifyObject(final int objectId, final GameWorld world) {
        if (!isObjectIdValid(objectId, world)) {
            return Optional.empty();
        }
        return Optional.ofNullable(world.modifyObjects().get(objectId));
    }

    @Override
    public Optional<GameObject> modifyPresentObject(final int objectId, final GameWorld world) {
        return modifyObject(objectId, world).filter(GameObject::isPresent);
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

}
