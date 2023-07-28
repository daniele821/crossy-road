package game.model.entity.api;

import java.util.List;

import game.model.logic.api.GameLogic;
import game.utility.Rectangle;

// this class represent a single map

public interface GameWorld {
    List<GameObject> getAllObjctes();

    void removeObject(GameObject objectToRemove);

    void addObject(GameObject newObject);

    Rectangle getGameWorldSize();

    void setGameWorldSize(Rectangle gameWorldSize);

    GameLogic getGameLogic();

    void setGameLogic(GameLogic gameLogic);
}
