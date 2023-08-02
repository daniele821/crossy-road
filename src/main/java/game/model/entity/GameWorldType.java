package game.model.entity;

public enum GameWorldType {
    MAP_1("1.toml");

    private final String mapPath;

    GameWorldType(final String mapPath) {
        this.mapPath = "game/map/" + mapPath;
    }

    public String getMapPath() {
        return this.mapPath;
    }
}
