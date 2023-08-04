package game.model.entity;

public enum GameWorldLevel {
    MAP_1("1.map");

    public final String path;

    GameWorldLevel(final String path) {
        this.path = "game/map/" + path;
    }
}
