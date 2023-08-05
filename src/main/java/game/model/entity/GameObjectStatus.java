package game.model.entity;

public interface GameObjectStatus {
    GameObjectStatus copy();

    GameObject getObject();

    int getId();

    boolean isPresent();

    void setPresent(boolean isPresent);
}
