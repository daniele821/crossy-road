package game.model.entity;

import java.util.List;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects;
    private GameWorldInfo gameWorldInfo;
    private GameWorldStatus gameWorldStatus;

    public GameWorldImpl(final List<GameObject> objects, final GameWorldInfo gameWorldInfo,
            final GameWorldStatus gameWorldStatus) {
        this.objects = List.copyOf(objects.stream().map(GameObject::copy).toList());
        this.gameWorldInfo = gameWorldInfo.copy();
        this.gameWorldStatus = gameWorldStatus.copy();
    }

    @Override
    public GameWorld copy() {
        return new GameWorldImpl(this.objects, this.gameWorldInfo, this.gameWorldStatus);
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
    public List<GameObject> getObjects() {
        return List.copyOf(objects.stream().map(GameObject::copy).toList());
    }

    @Override
    public List<GameObject> modifyObjects() {
        return List.copyOf(this.objects);
    }

    @Override
    public GameWorldStatus getGameWorldStatus() {
        return this.gameWorldStatus.copy();
    }

    @Override
    public void setGameWorldStatus(final GameWorldStatus gameWorldStatus) {
        this.gameWorldStatus = gameWorldStatus.copy();
    }

    @Override
    public String toString() {
        return "GameWorldImpl [objects=" + objects
                + ", gameWorldInfo=" + gameWorldInfo
                + ", gameWorldStatus=" + gameWorldStatus + "]";
    }

}
