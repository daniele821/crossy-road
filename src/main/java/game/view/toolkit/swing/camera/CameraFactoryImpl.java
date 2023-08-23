package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.Vector2D;

public class CameraFactoryImpl implements CameraFactory {
    private final Algorithms algorithms = new Algorithms();
    private final Vector2D maxCameraSize = new Vector2D(15, 15);

    @Override
    public Camera create(final GameWorld world) {
        final var cellSize = world.getGameWorldInfo().getCellSize();
        return new ResizableCamera(algorithms.multiplyMembers(maxCameraSize, cellSize));
    }

    @Override
    public Camera create() {
        return new ResizableCamera();
    }

}
