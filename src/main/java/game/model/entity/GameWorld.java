package game.model.entity;

import java.util.List;

public interface GameWorld {
    GameWorld copy();

    GameWorldInfo getGameWorldInfo();

    void setGameWorldInfo(GameWorldInfo gameWorldInfo);

    GameWorldStatus getGameWorldStatus();

    void setGameWorldStatus(GameWorldStatus gameWorldStatus);

    List<GameObject> getObjects();
}
