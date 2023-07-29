package game.model;

import java.util.List;

import game.model.entity.GameObject;
import game.model.logic.GameLogic;
import game.shared.Rectangle;

public interface GameWorld {
    List<GameObject> getAllObjctes();

    void removeObject(GameObject objectToRemove);

    void addObject(GameObject newObject);

    Rectangle getGameWorldSize();

    void setGameWorldSize(Rectangle gameWorldSize);

    GameLogic getGameLogic();

    void setGameLogic(GameLogic gameLogic);
}
