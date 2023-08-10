package game.view.toolkit.swing;

import java.awt.Toolkit;

import game.utility.ProgressiveTime;
import game.view.toolkit.swing.frame.SwingFrame;
import game.view.toolkit.swing.frame.SwingFrameImpl;
import game.view.toolkit.swing.panel.SwingMenuPanelImpl;
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
