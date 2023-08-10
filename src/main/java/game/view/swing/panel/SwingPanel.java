package game.view.swing.panel;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.view.swing.action.SwingAction;
import game.view.swing.frame.SwingFrame;

public interface SwingPanel {
    JPanel getPanel();

    SwingFrame getFrame();

    void setFrame(SwingFrame frame);

    void destroy();

    void putAction(List<KeyStroke> keyStrokes, SwingAction swingAction);

    void clearActions();
}
