package game.model.entity.util;

import java.util.List;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Pair;

public interface GameWorldUtil {
    List<Pair<Integer, GameObject>> getObjectsWithId(GameWorld world);

    List<Pair<Integer, GameObject>> getPresentObjectsWithId(GameWorld world);

    public Optional<GameObject> getObjectSafely(int objectId, GameWorld world);

    public Optional<GameObject> getPresentObjectSafely(int objectId, GameWorld world);

    public Optional<GameObject> modifyObjectSafely(int objectId, GameWorld world);

    public Optional<GameObject> modifyPresentObjectSafely(int objectId, GameWorld world);
}
