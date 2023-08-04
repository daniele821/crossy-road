package game.model.entity;

public class GameWorldImpl implements GameWorld {
    private GameWorldInfo gameWorldInfo;
    private GameWorldStatus gameWorldStatus;

    public GameWorldImpl(final GameWorldInfo gameWorldInfo, final GameWorldStatus gameWorldStatus) {
        this.gameWorldInfo = gameWorldInfo.copy();
        this.gameWorldStatus = gameWorldStatus.copy();
    }

    @Override
    public GameWorld copy() {
        return new GameWorldImpl(gameWorldInfo, gameWorldStatus);
    }

    @Override
    public GameWorldInfo getGameWorldInfo() {
        return this.gameWorldInfo.copy();
    }

    @Override
    public void setGameWorldInfo(final GameWorldInfo gameWorldInfo) {
        this.gameWorldInfo = gameWorldInfo.copy();
    }

    @Override
    public GameWorldStatus getGameWorldStatus() {
        return this.gameWorldStatus.copy();
    }

    @Override
    public void setGameWorldStatus(final GameWorldStatus gameWorldStatus) {
        this.gameWorldStatus = gameWorldStatus.copy();
    }

}
