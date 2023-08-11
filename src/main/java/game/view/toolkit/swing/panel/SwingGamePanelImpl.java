package game.view.toolkit.swing.panel;

import java.awt.Graphics;
import java.util.Optional;
import java.util.stream.IntStream;

import game.controller.engine.GameEngine;
import game.model.entity.GameObjectType.GameObjectKind;
import game.view.toolkit.swing.camera.BasicCamera;
import game.view.toolkit.swing.camera.Camera;

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

    @Override
    protected void paintComponent(final Graphics drawer) {
        super.paintComponent(drawer);
        final var world = getSwingFrame().getCurrentWorld();
        final var pov = IntStream.range(0, world.getObjects().size())
                .filter(i -> world.getObjects().get(i).getObjectType().getKind() == GameObjectKind.PLAYER)
                .mapToObj(Integer::valueOf)
                .toList();
        this.camera.get().draw(drawer, world, pov);
    }

}
