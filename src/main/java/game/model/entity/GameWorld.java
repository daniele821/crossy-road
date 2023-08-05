package game.model.entity;

import java.util.List;

public interface GameWorld {
    GameWorld copy();

    GameWorldInfo getGameWorldInfo();

    void setGameWorldInfo(GameWorldInfo gameWorldInfo);

    List<GameObject> getObjects();

    List<GameObject> modifyObjects();
}
