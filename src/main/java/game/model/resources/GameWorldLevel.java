package game.model.resources;

/** stores info about all available maps. */
public enum GameWorldLevel {
    LEVEL_1("game/map/1.map");

    private final String path;

    GameWorldLevel(final String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
