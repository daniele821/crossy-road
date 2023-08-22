package game.view.toolkit.swing.panel;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.view.toolkit.swing.frame.SwingFrame;
import game.view.toolkit.swing.input.SwingAction;

public interface SwingPanel {
    void start();

    void destroy();

    JPanel getJPanel();

    SwingFrame getSwingFrame();

    void setSwingFrame(SwingFrame frame);

    void putAction(List<KeyStroke> keyStrokes, SwingAction swingAction);

    void clearActions();
}
