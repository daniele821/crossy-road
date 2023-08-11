package game.model.entity.util;

import java.util.List;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Pair;

public interface GameWorldUtil {
    List<Pair<Integer, GameObject>> getObjectsId(GameWorld world);

    List<Pair<Integer, GameObject>> getPresentObjectsId(GameWorld world);

    public Optional<GameObject> getObject(int objectId, GameWorld world);

    public Optional<GameObject> getPresentObject(int objectId, GameWorld world);

    public Optional<GameObject> modifyObject(int objectId, GameWorld world);

    public Optional<GameObject> modifyPresentObject(int objectId, GameWorld world);
}
