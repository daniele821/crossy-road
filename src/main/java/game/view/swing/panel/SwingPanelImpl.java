package game.view.swing.panel;

import javax.swing.JPanel;

import game.view.swing.frame.SwingFrame;
import game.view.swing.window.SwingWindow;

public class SwingPanelImpl extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private SwingWindow window;
    private SwingFrame frame;

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public SwingWindow getWindow() {
        return this.window;
    }

    @Override
    public void setWindow(final SwingWindow window) {
        this.window = window;
    }

    @Override
    public SwingFrame getFrame() {
        return this.frame;
    }

    @Override
    public void setFrame(final SwingFrame frame) {
        this.frame = frame;
    }

}
