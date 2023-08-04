package game.model.entity;

public interface GameWorld {
    GameWorld copy();

    GameWorldInfo getGameWorldInfo();

    void setGameWorldInfo(GameWorldInfo gameWorldInfo);

    GameWorldStatus getGameWorldStatus();

    void setGameWorldStatus(GameWorldStatus gameWorldStatus);
}
