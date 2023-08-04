package game.model.entity;

public enum GameWorldType {
    MAP_1("1.map");

    public final String mapPath;

    GameWorldType(final String mapPath) {
        this.mapPath = "game/map/" + mapPath;
    }
}
