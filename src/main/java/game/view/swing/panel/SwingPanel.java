package game.view.swing.panel;

import javax.swing.JPanel;

import game.view.swing.frame.SwingFrame;

public interface SwingPanel {
    JPanel getPanel();

    SwingFrame getFrame();

    void setFrame(SwingFrame frame);

    void destroy();
}
