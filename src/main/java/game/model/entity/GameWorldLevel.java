package game.model.entity;

public enum GameWorldLevel {
    MAP_1("1.map");

    public static final String MAP_DIR = "game/map/";
    public final String path;

    GameWorldLevel(final String path) {
        this.path = MAP_DIR + path;
    }
}
