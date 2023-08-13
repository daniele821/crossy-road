package game.view.toolkit.swing.camera;

import java.awt.Graphics2D;
import java.awt.Image;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldInfo;
import game.utility.Rectangle;

/** @deprecated: use ResizableCamera instead */
@Deprecated
public class FullMapCamera extends AbstractCamera {

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2D, final GameWorld world, final int objectId) {
        final Rectangle mapArea = world.getGameWorldInfo().getWorldBounds();
        final double factor = calculateMinFactor(mapArea, drawArea);
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
            final Image image = IMAGE_LOADER.loadImage(obj.getObjectType().getPath(), lenX, lenY);
            drawer2D.drawImage(image, x, y, null);
        });
    }
}
