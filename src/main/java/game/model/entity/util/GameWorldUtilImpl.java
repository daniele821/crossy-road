package game.model.entity.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Pair;

public class GameWorldUtilImpl implements GameWorldUtil {

    @Override
    public List<Pair<Integer, GameObject>> getObjectsWithId(final GameWorld world) {
        return IntStream.range(0, world.getObjects().size())
                .mapToObj(i -> new Pair<>(i, world.getObjects().get(i)))
                .toList();
    }

    @Override
    public List<Pair<Integer, GameObject>> getPresentObjectsWithId(final GameWorld world) {
        return getObjectsWithId(world).stream().filter(pair -> pair.getB().isPresent()).toList();
    }

    @Override
    public Optional<GameObject> getObjectSafely(final int objectId, final GameWorld world) {
        if (objectId < 0 || objectId >= world.getObjects().size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(world.getObjects().get(objectId));
    }

    @Override
    public Optional<GameObject> getPresentObjectSafely(final int objectId, final GameWorld world) {
        return getObjectSafely(objectId, world).filter(GameObject::isPresent);
    }

    @Override
    public Optional<GameObject> modifyObjectSafely(final int objectId, final GameWorld world) {
        if (objectId < 0 || objectId >= world.getObjects().size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(world.modifyObjects().get(objectId));
    }

    @Override
    public Optional<GameObject> modifyPresentObjectSafely(final int objectId, final GameWorld world) {
        return modifyPresentObjectSafely(objectId, world).filter(GameObject::isPresent);
    }

}
