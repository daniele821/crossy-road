package game.view.swing.panel;

import javax.swing.JPanel;

import game.view.swing.frame.SwingFrame;
import game.view.swing.window.SwingWindow;

public interface SwingPanel {
    JPanel getPanel();

    SwingWindow getWindow();

    void setWindow(SwingWindow window);

    SwingFrame getFrame();

    void setFrame(SwingFrame frame);
}
