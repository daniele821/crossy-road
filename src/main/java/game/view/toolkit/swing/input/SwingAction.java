package game.view.toolkit.swing.input;

import java.awt.event.ActionEvent;

@FunctionalInterface
public interface SwingAction {
    void actionPerformed(ActionEvent e);
}
