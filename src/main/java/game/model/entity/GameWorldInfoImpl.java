package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public class GameWorldInfoImpl implements GameWorldInfo {
    private Rectangle bounds;
    private Vector2D cellSize;

    public GameWorldInfoImpl(final Rectangle bounds, final Vector2D cellSize) {
        this.bounds = bounds;
        this.cellSize = cellSize;
    }

    @Override
    public Rectangle getWorldBounds() {
        return this.bounds;
    }

    @Override
    public void setWorldBounds(final Rectangle bounds) {
        this.bounds = bounds;
    }

    @Override
    public Vector2D getCellSize() {
        return this.cellSize;
    }

    @Override
    public void setCellSize(final Vector2D cellSize) {
        this.cellSize = cellSize;
    }

}
