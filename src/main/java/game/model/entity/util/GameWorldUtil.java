package game.model.entity.util;

import java.util.List;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Pair;

public interface GameWorldUtil {
    List<GameObject> getObjects(GameWorld world);

    List<GameObject> getPresentObjects(GameWorld world);

    List<Pair<Integer, GameObject>> getObjectsWithId(GameWorld world);

    List<Pair<Integer, GameObject>> getPresentObjectsWithId(GameWorld world);

    Optional<GameObject> getObject(int objectId, GameWorld world);

    Optional<GameObject> getPresentObject(int objectId, GameWorld world);

    Optional<GameObject> modifyObject(int objectId, GameWorld world);

    Optional<GameObject> modifyPresentObject(int objectId, GameWorld world);

    int getSize(GameWorld world);

    boolean isObjectIdValid(int objectId, GameWorld world);
}
