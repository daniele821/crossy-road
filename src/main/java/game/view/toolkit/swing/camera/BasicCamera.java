package game.view.toolkit.swing.camera;

import java.awt.Graphics2D;
import java.awt.Image;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Rectangle;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public class BasicCamera implements Camera {
    private static final double FACTOR = 5;
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2D, final GameWorld world, final int objectId) {
        WORLD_UTIL.getPresentObjects(world).forEach(obj -> {
            final var info = world.getGameWorldInfo();
            final int x = (int) (FACTOR * (obj.getPosition().getX() - info.getWorldBounds().getX()));
            final int y = (int) (FACTOR * (obj.getPosition().getY() - info.getWorldBounds().getY()));
            final int lenX = (int) (FACTOR * obj.getPosition().getLenX());
            final int lenY = (int) (FACTOR * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer2D.drawImage(image, (int) (x + drawArea.getX()), (int) (y + drawArea.getY()), null);
        });
    }

}
