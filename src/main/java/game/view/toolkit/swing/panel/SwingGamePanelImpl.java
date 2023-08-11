package game.view.toolkit.swing.panel;

import java.util.Optional;

import game.controller.engine.GameEngine;
import game.view.toolkit.swing.camera.Camera;
import game.view.toolkit.swing.camera.BasicCamera;

public class SwingGamePanelImpl extends SwingPanelImpl implements SwingGamePanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private transient Optional<Camera> camera = Optional.ofNullable(new BasicCamera());

    @Override
    public void start() {
        super.start();
        final var window = getSwingFrame().getSwingWindow();
        final var world = getSwingFrame().getCurrentWorld();
        getSwingFrame().actOnGameEngine(engine -> engine.startThread(window, world));
    }

    @Override
    public void destroy() {
        super.destroy();
        getSwingFrame().actOnGameEngine(GameEngine::killThread);
    }

    @Override
    public void setCamera(final Camera camera) {
        this.camera = Optional.ofNullable(camera);
    }

}
