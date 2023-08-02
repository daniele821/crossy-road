package game.model.entity;

import java.util.List;

import game.model.logic.GameLogic;
import game.shared.Rectangle;
import game.shared.Vector2D;

public interface GameWorld {
    List<GameObject> getAllObjctes();

    void removeObject(GameObject objectToRemove);

    void addObject(GameObject newObject);

    Rectangle getGameWorldSize();

    void setGameWorldSize(Rectangle gameWorldSize);

    Vector2D getBackgroundCellDimension();

    void setBackgroundCellDimension(Vector2D backgroundCellSize);

    GameLogic getGameLogic();
}
