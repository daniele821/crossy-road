package game.model.entity;

public class GameObjectStatusImpl implements GameObjectStatus {
    private final GameObject object;
    private final int id;
    private boolean isPresent;

    public GameObjectStatusImpl(final GameObject object, final int id, final boolean isPresent) {
        this.object = object.copy();
        this.id = id;
        this.isPresent = isPresent;
    }

    @Override
    public GameObjectStatus copy() {
        return new GameObjectStatusImpl(this.object, this.id, this.isPresent);
    }

    @Override
    public GameObject getObject() {
        return this.object.copy();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isPresent() {
        return this.isPresent;
    }

    @Override
    public void setPresent(final boolean isPresent) {
        this.isPresent = isPresent;
    }

}
