package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;

public interface CameraFactory {
    Camera create(GameWorld world);

    Camera create();
}
