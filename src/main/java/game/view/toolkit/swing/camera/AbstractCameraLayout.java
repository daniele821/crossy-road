package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;

public abstract class AbstractCameraLayout implements CameraLayout {
    protected static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    protected static final Camera CAMERA = new ResizableCamera();

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        if (objectId.stream().filter(id -> !WORLD_UTIL.isObjectIdValid(id, world)).count() != 0) {
            throw new IllegalArgumentException("objectId (" + objectId + ") is not valid!");
        }
    }
}
