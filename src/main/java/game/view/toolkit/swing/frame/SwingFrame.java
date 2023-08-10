package game.view.toolkit.swing.frame;

import javax.swing.JFrame;

import game.view.toolkit.swing.SwingWindow;
import game.view.toolkit.swing.panel.SwingPanel;

public interface SwingFrame {
    JFrame getFrame();

    SwingPanel getSwingPanel();

    SwingWindow getSwingWindow();

    void setSwingPanel(SwingPanel panel);

    void setSwingWindow(SwingWindow swingWindow);
}
