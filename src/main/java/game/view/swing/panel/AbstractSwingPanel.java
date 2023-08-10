package game.view.swing.panel;

import javax.swing.JPanel;

import game.view.swing.frame.SwingFrame;

public abstract class AbstractSwingPanel extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private SwingFrame frame;

    @Override
    public JPanel getPanel() {
        return this;
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
