package game.view.toolkit.swing.panel;

import static game.model.entity.GameObjectType.GameObjectKind.PLAYER;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JPanel;

import game.controller.engine.GameEngine;
import game.model.entity.GameWorldUtil;
import game.model.entity.GameWorldUtilImpl;
import game.utility.Pair;
import game.view.toolkit.swing.camera.CameraLayout;
import game.view.toolkit.swing.camera.CameraLayoutFactoryImpl;
import game.view.toolkit.swing.input.GamePanelInput;

public class SwingGamePanelImpl extends SwingPanelImpl implements SwingGamePanel {
    private static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    private final Optional<Panel> panel = Optional.ofNullable(new Panel());
    private List<Integer> players = new ArrayList<>();
    private Optional<CameraLayout> cameraLayout = Optional.empty();

    @Override
    public void start() {
        super.start();
        final var window = getSwingFrame().getSwingWindow();
        final var world = getSwingFrame().getCurrentWorld();
        this.players = WORLD_UTIL.filterByKind(world, PLAYER).stream().map(Pair::getA).toList();
        new GamePanelInput(getSwingFrame()).getActions(world, this.players).forEach(this::putAction);
        this.cameraLayout = Optional.ofNullable(new CameraLayoutFactoryImpl().create(world));
        getSwingFrame().actOnGameEngine(engine -> engine.startThread(window, world));
    }

    @Override
    public void destroy() {
        super.destroy();
        getSwingFrame().actOnGameEngine(GameEngine::killThread);
    }

    @Override
    public JPanel getJPanel() {
        return this.panel.get();
    }

    private class Panel extends JPanel {
        private static final long serialVersionUID = 2115458124524211780L;

        @Override
        protected void paintComponent(final Graphics drawer) {
            super.paintComponent(drawer);
            cameraLayout.get().draw(drawer, getSwingFrame().getCurrentWorld(), players);
        }
    }

}
