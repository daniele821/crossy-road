package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;

public interface CameraFactory {
    Camera create(final GameWorld world);

    Camera create();
}
