package game.view.swing.scene;

import game.utility.ProgressiveTime;
import game.view.window.AbstractWindow;

public class SwingWindow extends AbstractWindow {
    private final SwingMainFrame frame = new SwingMainFrame();
    private final SwingGamePanel gamePanel = new SwingGamePanel();

    public SwingWindow() {
        this.frame.setSwingPanel(gamePanel);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        // TODO
    }

}
