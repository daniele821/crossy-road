package game.view.toolkit.swing.frame;

import javax.swing.JFrame;

import game.view.toolkit.swing.panel.SwingPanel;
import game.view.toolkit.swing.window.SwingWindow;

public interface SwingFrame {

    void start();

    void updateRenderer();

    JFrame getFrame();

    SwingPanel getSwingPanel();

    SwingWindow getSwingWindow();

    void setSwingPanel(SwingPanel panel);

    void setSwingWindow(SwingWindow swingWindow);
}
