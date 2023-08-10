package game.view.swing.window;

import java.awt.Toolkit;

import game.utility.ProgressiveTime;
import game.view.swing.frame.SwingFrame;
import game.view.swing.frame.SwingFrameImpl;
import game.view.swing.panel.SwingMenuPanelImpl;
import game.view.window.AbstractWindow;

public class SwingWindow extends AbstractWindow {
    private final SwingFrame frame = new SwingFrameImpl();

    @Override
    public void start() {
        this.frame.setSwingWindow(this);
        this.frame.setSwingPanel(new SwingMenuPanelImpl());
    }

    @Override
    public void update(final ProgressiveTime elapsedTime) {
        this.frame.getFrame().repaint();
        Toolkit.getDefaultToolkit().sync();
    }

}
