package game.view.toolkit.swing.panel;

import java.awt.Graphics;
import java.util.Optional;

import game.controller.engine.GameEngine;
import game.utility.Rectangle;
import game.view.toolkit.swing.camera.Camera;
import game.view.toolkit.swing.camera.PlayerCamera;

public class SwingGamePanelImpl extends SwingPanelImpl implements SwingGamePanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private transient Optional<Camera> camera = Optional.ofNullable(new PlayerCamera());

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

    @Override
    protected void paintComponent(final Graphics drawer) {
        super.paintComponent(drawer);
        final var width = drawer.getClipBounds().getWidth();
        final var height = drawer.getClipBounds().getHeight();
        final var drawArea = new Rectangle(0, 0, width, height);
        this.camera.get().draw(drawArea, drawer, getSwingFrame().getCurrentWorld(), 0);
        // TODO
    }

}
