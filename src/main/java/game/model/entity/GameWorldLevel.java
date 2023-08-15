package game.model.entity;

public enum GameWorldLevel {
    MAP_0("0.map", "DEMO"),
    MAP_1("1.map", "1");

    private static final String MAP_DIR = "game/map/";
    private final String path;
    private final String levelName;

    GameWorldLevel(final String path, final String levelName) {
        this.path = MAP_DIR + path;
        this.levelName = levelName;
    }

    public String getPath() {
        return this.path;
    }

    public String getLevelName() {
        return this.levelName;
    }
}
