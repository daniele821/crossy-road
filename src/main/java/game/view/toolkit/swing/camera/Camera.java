package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.model.entity.GameWorld;
import game.utility.Rectangle;

public interface Camera {
    void draw(Rectangle drawArea, Graphics2D drawer2D, GameWorld world, int objectId);

    default void draw(Rectangle drawArea, Graphics drawer, GameWorld world, int objectId) {
        final Graphics2D drawer2D = (Graphics2D) drawer;
        drawer2D.clip(new java.awt.Rectangle((int) drawArea.getX(), (int) drawArea.getY(),
                (int) drawArea.getLenX(), (int) drawArea.getLenY()));
        draw(drawArea, drawer2D, world, objectId);
        drawer2D.setClip(null);
    }
}
