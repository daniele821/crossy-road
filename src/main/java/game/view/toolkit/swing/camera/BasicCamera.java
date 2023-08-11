package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public class BasicCamera implements Camera {
    private static final double FACTOR = 8;
    private final GameWorldUtil worldUtil = new GameWorldUtilImpl();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        worldUtil.getPresentObjects(world).forEach(obj -> {
            final int x = (int) (FACTOR * obj.getPosition().getX());
            final int y = (int) (FACTOR * obj.getPosition().getY());
            final int lenX = (int) (FACTOR * obj.getPosition().getLenX());
            final int lenY = (int) (FACTOR * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer.drawImage(image, x, y, null);
        });
    }

}
