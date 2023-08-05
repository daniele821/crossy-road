package game.model.entity;

import java.util.List;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects;
    private GameWorldInfo gameWorldInfo;

    public GameWorldImpl(final List<GameObject> objects, final GameWorldInfo gameWorldInfo) {
        this.objects = List.copyOf(objects.stream().map(GameObject::copy).toList());
        this.gameWorldInfo = gameWorldInfo.copy();
    }

    @Override
    public GameWorld copy() {
        return new GameWorldImpl(this.objects, this.gameWorldInfo);
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

}
