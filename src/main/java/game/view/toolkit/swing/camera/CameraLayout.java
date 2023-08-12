package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;

import game.model.entity.GameWorld;

public interface CameraLayout {
    void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId);
}
