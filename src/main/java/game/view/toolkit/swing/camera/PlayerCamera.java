package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;
import game.utility.Vector2D;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public class PlayerCamera implements Camera {
    private static final double FACTOR = 8;
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        final var info = world.getGameWorldInfo();
        final var canvas = drawer.getClipBounds();
        final GameObject player = WORLD_UTIL.getPresentObject(objectId.get(0), world).get();
        final Rectangle playerPos = ALGORITHMS.multiply(player.getPosition(), FACTOR);
        final Vector2D playerToBorder = new Vector2D(
                (canvas.getWidth() - playerPos.getLenX()) / 2,
                (canvas.getHeight() - playerPos.getLenY()) / 2);
        final Vector2D topLeftCorner = new Vector2D(
                playerToBorder.getX() - playerPos.getX(),
                playerToBorder.getY() - playerPos.getY());

        WORLD_UTIL.getPresentObjects(world).forEach(obj -> {
            final int x = (int) (FACTOR * (obj.getPosition().getX() - info.getWorldBounds().getX()) + topLeftCorner.getX());
            final int y = (int) (FACTOR * (obj.getPosition().getY() - info.getWorldBounds().getY()) + topLeftCorner.getY());
            final int lenX = (int) (FACTOR * obj.getPosition().getLenX());
            final int lenY = (int) (FACTOR * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer.drawImage(image, x, y, null);
        });
    }

}
