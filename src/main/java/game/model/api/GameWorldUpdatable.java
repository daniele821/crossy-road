package game.model.api;

/** methods to update game objects. */
public interface GameWorldUpdatable {
    /** update position of all objects based on their speed. */
    void moveAll();
}
