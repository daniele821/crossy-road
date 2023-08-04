package game.model.entity;

public interface GameWorld {
    GameWorldInfo getGameWorldInfo();

    void setGameWorldInfo(GameWorldInfo gameWorldInfo);

    GameWorldStatus getGameWorldStatus();

    void setGameWorldStatus(GameWorldStatus gameWorldStatus);
}
