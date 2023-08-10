package game.view.swing.frame;

import javax.swing.JFrame;

import game.view.swing.SwingWindow;
import game.view.swing.panel.SwingPanel;

public interface SwingFrame {
    JFrame getFrame();

    SwingPanel getSwingPanel();

    SwingWindow getSwingWindow();

    void setSwingPanel(SwingPanel panel);

    void setSwingWindow(SwingWindow swingWindow);
}
