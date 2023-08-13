package game.view.toolkit.swing.camera;

import java.awt.Graphics2D;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldInfo;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class ResizableCamera extends AbstractCamera {
    private final Optional<Vector2D> maxSizeCamera;

    private ResizableCamera(final Optional<Vector2D> maxSizeCamera) {
        this.maxSizeCamera = maxSizeCamera;
    }

    public ResizableCamera(final Vector2D maxSizeCamera) {
        this(Optional.ofNullable(maxSizeCamera));
    }

    public ResizableCamera() {
        this(Optional.empty());
    }

    @Override
    public void draw(final Rectangle drawArea, final Graphics2D drawer2d, final GameWorld world, final int objectId) {
        final Optional<GameObject> object = WORLD_UTIL.getPresentObject(objectId, world);
        if (object.isEmpty()) {
            return;
        }

        final double factor = calculateMinFactor(calculateMaxSizeCamera(world), drawArea);
        final Vector2D mapSize = calculateMapSize(drawArea, factor);
        final Rectangle mapArea = calculateMapArea(mapSize, world.getGameWorldInfo(), object.get());
    }

    private Vector2D calculateMaxSizeCamera(final GameWorld gameWorld) {
        final double worldSizeX = gameWorld.getGameWorldInfo().getWorldBounds().getLenX();
        final double worldSizeY = gameWorld.getGameWorldInfo().getWorldBounds().getLenY();
        final Vector2D size = this.maxSizeCamera.orElse(new Vector2D(worldSizeX, worldSizeY));
        final double sizeX = Double.max(1, Double.min(worldSizeX, size.getX()));
        final double sizeY = Double.max(1, Double.min(worldSizeY, size.getY()));
        return new Vector2D(sizeX, sizeY);
    }

    private Vector2D calculateMapSize(final Rectangle drawArea, final double factor) {
        final Vector2D drawAreaSize = new Vector2D(drawArea.getLenX(), drawArea.getLenY());
        return ALGORITHMS.multiply(drawAreaSize, 1.0 / factor);
    }

    private Rectangle calculateMapArea(final Vector2D mapSize, final GameWorldInfo info, final GameObject object) {
        final double idealObjToWallWidth = (mapSize.getX() - object.getPosition().getLenX()) / 2.0;
        final double idealObjToWallHeight = (mapSize.getY() - object.getPosition().getLenY()) / 2.0;
        final double leftWall = info.getWorldBounds().getX();
        final double rightWall = info.getWorldBounds().getX() + info.getWorldBounds().getLenX();
        final double topWall = info.getWorldBounds().getY();
        final double downWall = info.getWorldBounds().getY() + info.getWorldBounds().getLenY();
        final double leftObj = object.getPosition().getX();
        final double topObj = object.getPosition().getY();
        final double leftWallObjDelta = leftObj - leftWall;
        final double topWallObjDelta = topObj - topWall;
        final double leftDelta = Double.min(idealObjToWallWidth, leftWallObjDelta);
        final double topDelta = Double.min(idealObjToWallHeight, topWallObjDelta);
        final double topLeftX = leftObj - leftDelta;
        final double topLeftY = topObj - topDelta;
        final double fixedTopLeftX = Double.min(rightWall - mapSize.getX(), topLeftX);
        final double fixedTopLeftY = Double.min(downWall - mapSize.getY(), topLeftY);
        return new Rectangle(fixedTopLeftX, fixedTopLeftY, mapSize.getX(), mapSize.getY());
    }
}
