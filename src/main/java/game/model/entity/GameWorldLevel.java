package game.model.entity;

public enum GameWorldLevel {
    MAP_1("1.map");

    private static final String MAP_DIR = "game/map/";
    private final String path;

    GameWorldLevel(final String path) {
        this.path = MAP_DIR + path;
    }

    public String getPath() {
        return this.path;
    }
}
