package game.view.swing.scene;

import java.util.Optional;

import javax.swing.JFrame;

public interface SwingFrame {
    JFrame getFrame();

    void setSwingPanel(SwingPanel panel);

    Optional<SwingPanel> getSwingPanel();
}
