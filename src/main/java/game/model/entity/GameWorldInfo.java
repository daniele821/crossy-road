package game.model.entity;

import game.common.Rectangle;
import game.common.Vector2D;

public interface GameWorldInfo {
    GameWorldInfo copy();

    Rectangle getWorldBounds();

    void setWorldBounds(Rectangle bounds);

    Vector2D getCellSize();

    void setCellSize(Vector2D cellSize);
}
