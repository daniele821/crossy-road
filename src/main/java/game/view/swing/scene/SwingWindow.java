package game.view.swing.scene;

import game.utility.ProgressiveTime;
import game.view.window.AbstractWindow;

public class SwingWindow extends AbstractWindow {
    private final SwingMainFrame frame = new SwingMainFrame();
    private final SwingGamePanel gamePanel = new SwingGamePanel();
    private final SwingMenuPanel menuPanel = new SwingMenuPanel();
    private final SwingLevelPanel levelPanel = new SwingLevelPanel();

    public SwingWindow() {
        this.frame.setSwingPanel(this.menuPanel);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        // TODO
    }

}
