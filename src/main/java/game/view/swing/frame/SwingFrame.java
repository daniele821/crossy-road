package game.view.swing.frame;

import javax.swing.JFrame;

import game.view.swing.panel.SwingPanel;

public interface SwingFrame {
    JFrame getFrame();

    void setSwingPanel(SwingPanel panel);

    SwingPanel getSwingPanel();
}
