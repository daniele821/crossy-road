package game.view.toolkit.swing.panel;

import java.awt.Graphics;
import java.util.List;

import game.controller.engine.GameEngine;
import game.view.toolkit.swing.input.GamePanelInput;

public class SwingGamePanelImpl extends SwingPanelImpl implements SwingGamePanel {
    private static final long serialVersionUID = 2115458124524211780L;

    @Override
    public void start() {
        super.start();
        final var window = getSwingFrame().getSwingWindow();
        final var world = getSwingFrame().getCurrentWorld();
        getSwingFrame().actOnGameEngine(engine -> engine.startThread(window, world));
        new GamePanelInput(getSwingFrame()).getActions(world, List.of()).forEach(this::putAction);
    }

    @Override
    public void destroy() {
        super.destroy();
        getSwingFrame().actOnGameEngine(GameEngine::killThread);
    }

    @Override
    protected void paintComponent(final Graphics drawer) {
        super.paintComponent(drawer);
        // TODO draw game
    }

}
