package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public class GameWorldInfoImpl implements GameWorldInfo {
    private Rectangle bounds;
    private Vector2D cellSize;

    public static GameWorldInfo clone(final GameWorldInfo gameWorldInfo) {
        return new GameWorldInfoImpl(gameWorldInfo.getWorldBounds(), gameWorldInfo.getCellSize());
    }

    public GameWorldInfoImpl(final Rectangle bounds, final Vector2D cellSize) {
        this.bounds = Rectangle.clone(bounds);
        this.cellSize = Vector2D.clone(cellSize);
    }

    @Override
    public Rectangle getWorldBounds() {
        return Rectangle.clone(this.bounds);
    }

    @Override
    public void setWorldBounds(final Rectangle bounds) {
        this.bounds = Rectangle.clone(bounds);
    }

    @Override
    public Vector2D getCellSize() {
        return Vector2D.clone(this.cellSize);
    }

    @Override
    public void setCellSize(final Vector2D cellSize) {
        this.cellSize = Vector2D.clone(cellSize);
    }

}
