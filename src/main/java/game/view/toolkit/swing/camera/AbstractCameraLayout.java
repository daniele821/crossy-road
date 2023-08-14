package game.view.toolkit.swing.camera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;

public abstract class AbstractCameraLayout implements CameraLayout {
    protected static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    protected static final Algorithms ALGORITHMS = new Algorithms();
    protected static final Camera CAMERA = new ResizableCamera();
    protected static final Color BORDER_COLOR = Color.DARK_GRAY;
    protected static final int BORDER_WIDTH = 10;

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        if (objectId.stream().filter(id -> !WORLD_UTIL.isObjectIdValid(id, world)).count() != 0) {
            throw new IllegalArgumentException("objectId (" + objectId + ") is not valid!");
        }
    }
}
