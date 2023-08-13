package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;
import game.utility.Vector2D;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public abstract class AbstractCamera implements Camera {
    // 1: fix white lines, 0: precise image size
    protected static final int INCREASE_IMAGE_SIZE_BY = 1;
    protected static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    protected static final Algorithms ALGORITHMS = new Algorithms();
    protected static final ImageBufferedLoader IMAGE_LOADER = new ImageBufferedLoaderImpl();

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
