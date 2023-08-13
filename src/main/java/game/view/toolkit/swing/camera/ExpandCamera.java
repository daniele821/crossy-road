package game.view.toolkit.swing.camera;

import java.awt.Graphics2D;

import game.model.entity.GameWorld;
import game.utility.Rectangle;

/**
 * <p>
 * Camera does never scale.
 * </p>
 * <p>
 * Camera scale is calculated once to be the smallest possible factor which
 * allows to leave no white spaces.
 * </p>
 * <p>
 * On canvas size increases more of the world is shown and viceversa.
 * </p>
 * <p>
 * It's possible to set the maximum rectangle dimension to draw.
 * </p>
 */
public class ExpandCamera extends AbstractCamera {
    private final double minFactor;

    public ExpandCamera(final double minFactor) {
        this.minFactor = minFactor;
    }

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2D, final GameWorld world, final int objectId) {
        draw(drawArea, drawer2D, world, objectId, Double.max(this.minFactor, calculateMinFactor(world, drawArea)));
    }

    public void draw(final Rectangle drawArea, final Graphics2D drawer2D,
            final GameWorld world, final int objectId, final double factor) {

    }

}
