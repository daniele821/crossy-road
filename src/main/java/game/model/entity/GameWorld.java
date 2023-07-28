package game.model.entity;

import java.util.List;

import game.model.logic.GameLogic;
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
