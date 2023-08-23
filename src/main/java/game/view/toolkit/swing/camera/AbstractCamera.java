package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;
import game.utility.Vector2D;
import game.view.toolkit.swing.SwingAlgorithms;

public abstract class AbstractCamera implements Camera {
    protected static final int INCREASE_IMAGE_SIZE_BY = 1;
    private final SwingAlgorithms swingUtil = new SwingAlgorithms();

    protected abstract void draw(Rectangle drawArea, Graphics2D drawer2D, GameWorld world, GameObject object);

    @Override
    public final void draw(final Rectangle drawArea, final Graphics drawer, final GameWorld world,
            final GameObject object) {
        if (!(drawer instanceof Graphics2D)) {
            throw new IllegalStateException("cannot cast from Graphics to Graphics2D");
        }

        final Graphics2D drawer2D = (Graphics2D) drawer;

        drawer2D.clip(swingUtil.convertRectangle(drawArea));
        draw(drawArea, drawer2D, world, object);
        drawer2D.setClip(null);
    }

    protected double calculateMinFactor(final Rectangle mapArea, final Rectangle drawArea) {
        final double heightMap = mapArea.getLenY();
        final double widthMap = mapArea.getLenX();
        final double heightCanvas = drawArea.getLenY();
        final double widthCanvas = drawArea.getLenX();
        return Double.max(heightCanvas / heightMap, widthCanvas / widthMap);
    }

    protected double calculateMinFactor(final Vector2D mapSize, final Rectangle drawArea) {
        return calculateMinFactor(new Rectangle(0, 0, mapSize.getX(), mapSize.getY()), drawArea);
    }

}
