package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.Vector2D;

public class CameraFactoryImpl implements CameraFactory {
    private static final Algorithms ALGORITHMS = new Algorithms();
    private static final Vector2D MAX_CAMERA_SIZE = new Vector2D(15, 15);

    @Override
    public Camera create(final GameWorld world) {
        final var cellSize = world.getGameWorldInfo().getCellSize();
        return new ResizableCamera(ALGORITHMS.multiplyMembers(MAX_CAMERA_SIZE, cellSize));
    }

    @Override
    public Camera create() {
        return new ResizableCamera();
    }

}
