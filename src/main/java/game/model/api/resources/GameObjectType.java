package game.model.api.resources;

import game.common.Rectangle;

/** store all object types and info about them. */
public enum GameObjectType {
    ;

    private final String path;
    private final Rectangle posInCell;

    GameObjectType(final String path, final Rectangle posInCell) {
        this.path = path;
        this.posInCell = posInCell;
    }

    public String getPath() {
        return this.path;
    }

    public Rectangle getPosInCell() {
        return this.posInCell;
    }
}
