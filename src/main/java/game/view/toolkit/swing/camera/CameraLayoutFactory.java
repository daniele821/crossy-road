package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;
import game.view.toolkit.swing.camera.TilingCameraLayout.Layout;

public interface CameraLayoutFactory {
    CameraLayout create(Layout layout, GameWorld world);

    CameraLayout create(GameWorld world);

    CameraLayout create(Layout layout);

    CameraLayout create();
}
