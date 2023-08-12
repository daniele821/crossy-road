package game.view.toolkit.swing.camera;

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

public class PlayerCamera extends AbstractCamera {
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();
    private final double factor;

    public PlayerCamera(final double factor) {
        this.factor = factor;
    }

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2D, final GameWorld world, final int objectId) {
        final GameObject object = WORLD_UTIL.getPresentObject(objectId, world).get();
        final Rectangle objectPos = ALGORITHMS.multiply(object.getPosition(), factor);
        final double objectToBorderOriz = (drawArea.getLenX() - objectPos.getLenX()) / 2;
        final double objectToBorderVert = (drawArea.getLenY() - objectPos.getLenY()) / 2;
        final double leftCorner = objectToBorderOriz - objectPos.getX();
        final double topCorner = objectToBorderVert - objectPos.getY();

        WORLD_UTIL.getPresentObjects(world).forEach(obj -> {
            final int x = (int) (factor * (obj.getPosition().getX()) + leftCorner + drawArea.getX());
            final int y = (int) (factor * (obj.getPosition().getY()) + topCorner + drawArea.getY());
            final int lenX = (int) (factor * obj.getPosition().getLenX());
            final int lenY = (int) (factor * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer2D.drawImage(image, x, y, null);
        });
    }
}
