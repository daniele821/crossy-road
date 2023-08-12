package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.model.entity.GameWorld;
import game.utility.Rectangle;

public interface Camera {
    void draw(Rectangle drawArea, Graphics2D drawer2D, GameWorld world, int objectId);

    void draw(Rectangle drawArea, Graphics drawer, GameWorld world, int objectId);
}
