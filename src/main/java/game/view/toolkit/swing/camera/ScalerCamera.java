package game.view.toolkit.swing.camera;

import java.awt.Graphics2D;
import java.awt.Image;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldInfo;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;
import game.view.toolkit.swing.imageloader.ImageBufferedLoader;
import game.view.toolkit.swing.imageloader.ImageBufferedLoaderImpl;

public class ScalerCamera extends AbstractCamera {
    // 1: fix white lines, 0: precise image size
    private static final int INCREASE_IMAGE_SIZE_BY = 1;
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private static final Algorithms ALGORITHMS = new Algorithms();
    private final ImageBufferedLoader imageLoader = new ImageBufferedLoaderImpl();

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2D, final GameWorld world, final int objectId) {
        final GameWorldInfo info = world.getGameWorldInfo();
        final double heightMap = info.getWorldBounds().getLenY();
        final double widthMap = info.getWorldBounds().getLenX();
        final double heightCanvas = drawArea.getLenY();
        final double widthCanvas = drawArea.getLenX();
        final double factor = Double.max(heightCanvas / heightMap, widthCanvas / widthMap);
        draw(drawArea, drawer2D, world, objectId, factor);
    }

    public void draw(final Rectangle drawArea, final Graphics2D drawer2D,
            final GameWorld world, final int objectId, final double factor) {

        // center object
        final GameWorldInfo info = world.getGameWorldInfo();
        final GameObject object = WORLD_UTIL.getPresentObject(objectId, world).get();
        final Rectangle objectPos = ALGORITHMS.multiply(object.getPosition(), factor);
        final double objectToBorderOriz = (drawArea.getLenX() - objectPos.getLenX()) / 2;
        final double objectToBorderVert = (drawArea.getLenY() - objectPos.getLenY()) / 2;
        final double leftCorner = objectToBorderOriz - objectPos.getX();
        final double topCorner = objectToBorderVert - objectPos.getY();

        // offset camera to avoid going outside map (ORIZ)
        final double rightMap = info.getWorldBounds().getX() + info.getWorldBounds().getLenX();
        final double rightObj = object.getPosition().getX() + object.getPosition().getLenX();
        final double right = (rightMap - rightObj) * factor;
        final double leftMap = info.getWorldBounds().getX();
        final double leftObj = object.getPosition().getX();
        final double left = (leftMap - leftObj) * factor;
        final double offsetOriz = Double.max(0, objectToBorderOriz - right) - Double.max(0, objectToBorderOriz + left);

        // offset camera to avoid going outside map (VERT)
        final double downMap = info.getWorldBounds().getY() + info.getWorldBounds().getLenY();
        final double downObj = object.getPosition().getY() + object.getPosition().getLenY();
        final double down = (downMap - downObj) * factor;
        final double upMap = info.getWorldBounds().getY();
        final double upObj = object.getPosition().getY();
        final double up = (upMap - upObj) * factor;
        final double offsetVert = Double.max(0, objectToBorderVert - down) - Double.max(0, objectToBorderVert + up);

        WORLD_UTIL.getPresentObjects(world).forEach(obj -> {
            final int x = (int) (factor * (obj.getPosition().getX()) + leftCorner + drawArea.getX() + offsetOriz);
            final int y = (int) (factor * (obj.getPosition().getY()) + topCorner + drawArea.getY() + offsetVert);
            final int lenX = INCREASE_IMAGE_SIZE_BY + (int) (factor * obj.getPosition().getLenX());
            final int lenY = INCREASE_IMAGE_SIZE_BY + (int) (factor * obj.getPosition().getLenY());
            final Image image = this.imageLoader.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer2D.drawImage(image, x, y, null);
        });
    }
}
