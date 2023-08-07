package game.view.swing.scene;

import game.utility.ProgressiveTime;
import game.view.window.AbstractWindow;

public class SwingWindow extends AbstractWindow {
    private final SwingFrame frame = new SwingFrame();
    private final SwingGamePanel gamePanel = new SwingGamePanel();

    public SwingWindow() {
        this.frame.add(this.gamePanel);
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        // TODO
    }

}
