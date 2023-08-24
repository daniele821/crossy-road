package game.view.toolkit.swing.camera;

import game.model.entity.GameWorld;
import game.view.toolkit.swing.camera.TilingCameraLayout.Layout;

public class CameraLayoutFactoryImpl implements CameraLayoutFactory {
    private static final Layout DEFAULT_LAYOUT = Layout.RECT_WITH_EMPTY_SPOT;

    @Override
    public CameraLayout create(final Layout layout, final GameWorld world) {
        return new TilingCameraLayout(layout, new CameraFactoryImpl().create(world));
    }

    @Override
    public CameraLayout create(final GameWorld world) {
        return create(DEFAULT_LAYOUT, world);
    }

    @Override
    public CameraLayout create(final Layout layout) {
        return new TilingCameraLayout(layout, new CameraFactoryImpl().create());
    }

    @Override
    public CameraLayout create() {
        return create(DEFAULT_LAYOUT);
    }

}
