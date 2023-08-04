package game.model.entity;

import game.shared.Rectangle;
import game.shared.Vector2D;

public interface GameWorldInfo {
    Rectangle getWorldBounds();

    void setWorldBounds(Rectangle bounds);

    Vector2D getCellSize();

    void setCellSize(Vector2D cellSize);
}
