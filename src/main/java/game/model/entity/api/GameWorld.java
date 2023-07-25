package game.model.entity.api;

import java.util.List;

public interface GameWorld {
    List<GameObject> getAllObjctes();

    void removeObject(int nth);

    void addObject(GameObject newObject);
}
