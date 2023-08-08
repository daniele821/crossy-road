package game.view.swing.scene;

import game.utility.ProgressiveTime;
import game.view.window.AbstractWindow;

public class SwingWindow extends AbstractWindow {
    private final SwingFrame frame = new SwingFrameImpl();
    private final SwingPanel gamePanel = new SwingGamePanel();

    public SwingWindow() {
        this.frame.getFrame().add(this.gamePanel.getPanel());
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        // TODO
    }

}
