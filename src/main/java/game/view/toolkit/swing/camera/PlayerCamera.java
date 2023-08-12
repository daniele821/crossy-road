package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public class PlayerCamera implements Camera {
    private static final double FACTOR = 8;
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();

    @Override
    public void draw(final Rectangle drawArea, final Graphics drawer, final GameWorld world, final int objectId) {
        final Graphics2D drawer2D = (Graphics2D) drawer;
        final GameObject object = WORLD_UTIL.getPresentObject(objectId, world).get();
        final Rectangle objectPos = ALGORITHMS.multiply(object.getPosition(), FACTOR);
        final double objectToBorderOriz = (drawArea.getLenX() - objectPos.getLenX()) / 2;
        final double objectToBorderVert = (drawArea.getLenY() - objectPos.getLenY()) / 2;
        final double leftCorner = objectToBorderOriz - objectPos.getX();
        final double topCorner = objectToBorderVert - objectPos.getY();
        final int drawAreaX = (int) drawArea.getX();
        final int drawAreaY = (int) drawArea.getY();
        final int drawAreaLenX = (int) drawArea.getLenX();
        final int drawAreaLenY = (int) drawArea.getLenY();
        drawer2D.clip(new java.awt.Rectangle(drawAreaX, drawAreaY, drawAreaLenX, drawAreaLenY));
        WORLD_UTIL.getPresentObjects(world).forEach(obj -> {
            final int x = (int) (FACTOR * (obj.getPosition().getX()) + leftCorner + drawArea.getX());
            final int y = (int) (FACTOR * (obj.getPosition().getY()) + topCorner + drawArea.getY());
            final int lenX = (int) (FACTOR * obj.getPosition().getLenX());
            final int lenY = (int) (FACTOR * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer2D.drawImage(image, x, y, null);
        });
        drawer2D.setClip(null);
    }
}
