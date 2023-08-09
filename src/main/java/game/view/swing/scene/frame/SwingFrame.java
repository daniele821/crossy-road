package game.view.swing.scene.frame;

import javax.swing.JFrame;

import game.view.swing.scene.panel.SwingPanel;

public interface SwingFrame {
    JFrame getFrame();

    void setSwingPanel(SwingPanel panel);

    SwingPanel getSwingPanel();
}
