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
    public Optional<GameObject> getObject(final int objectId, final GameWorld world) {
        if (objectId < 0 || objectId >= world.getObjects().size()) {
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
        if (objectId < 0 || objectId >= world.getObjects().size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(world.modifyObjects().get(objectId));
    }

    @Override
    public Optional<GameObject> modifyPresentObject(final int objectId, final GameWorld world) {
        return modifyObject(objectId, world).filter(GameObject::isPresent);
    }

}
