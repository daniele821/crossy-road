package game.model.entity;

public enum GameWorldType {
    MAP_1("1.map");

    public final String path;

    GameWorldType(final String path) {
        this.path = "game/map/" + path;
    }
}
