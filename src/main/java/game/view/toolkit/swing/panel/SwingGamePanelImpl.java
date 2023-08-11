package game.view.toolkit.swing.panel;

import game.controller.engine.GameEngine;

public class SwingGamePanelImpl extends SwingPanelImpl implements SwingGamePanel {
    private static final long serialVersionUID = 2115458124524211780L;

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

}
