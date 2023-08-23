package game.model.entity;

import java.util.List;
import java.util.Optional;

import game.model.entity.GameObjectType.GameObjectKind;
import game.utility.Pair;
import game.utility.Rectangle;
import game.utility.Vector2D;

public interface GameWorldUtil {
    List<GameObject> getObjects(GameWorld world);

    List<GameObject> getPresentObjects(GameWorld world);

    List<Pair<Integer, GameObject>> getObjectsWithId(GameWorld world);

    List<Pair<Integer, GameObject>> getPresentObjectsWithId(GameWorld world);

    Optional<GameObject> getObject(int objectId, GameWorld world);

    Optional<GameObject> getPresentObject(int objectId, GameWorld world);

    int getSize(GameWorld world);

    boolean isObjectIdValid(int objectId, GameWorld world);

    List<Pair<Integer, GameObject>> filterByKind(GameWorld world, GameObjectKind kind);

    List<Pair<Integer, GameObject>> filterByKindPresent(GameWorld world, GameObjectKind kind);

    Vector2D convertCellToPixel(Vector2D cellPos, GameWorldInfo info, GameObjectType type);

    Vector2D convertPixelToCell(Vector2D cellPos, GameWorldInfo info, GameObjectType type);

    Vector2D roundPosToCellPos(Vector2D pos, GameWorldInfo info, GameObjectType type);

    List<Pair<Integer, GameObject>> getColliding(GameWorld world, int objectId, Rectangle newPos);
}
