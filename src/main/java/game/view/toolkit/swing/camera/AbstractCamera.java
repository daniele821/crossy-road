package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.model.entity.GameWorld;
import game.utility.Rectangle;

public abstract class AbstractCamera implements Camera {
    @Override
    public void draw(final Rectangle drawArea, final Graphics drawer, final GameWorld world, final int objectId) {
        if (!(drawer instanceof Graphics2D)) {
            throw new IllegalStateException("cannot cast from Graphics to Graphics2D");
        }
        final Graphics2D drawer2D = (Graphics2D) drawer;
        drawer2D.clip(new java.awt.Rectangle((int) drawArea.getX(), (int) drawArea.getY(),
                (int) drawArea.getLenX(), (int) drawArea.getLenY()));
        draw(drawArea, drawer2D, world, objectId);
        drawer2D.setClip(null);
    }
}
