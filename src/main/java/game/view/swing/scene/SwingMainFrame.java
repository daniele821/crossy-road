package game.view.swing.scene;

import java.awt.Toolkit;
import java.util.Optional;

import javax.swing.JFrame;

public class SwingMainFrame extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;
    private SwingPanel panel;

    public SwingMainFrame() {
        setTitle("Crossy-Road");
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public JFrame getFrame() {
        return this;
    }

    @Override
    public void setSwingPanel(final SwingPanel panel) {
        Optional.ofNullable(this.panel).map(SwingPanel::getPanel).ifPresent(getFrame()::remove);
        this.panel = panel;
        Optional.ofNullable(this.panel).map(SwingPanel::getPanel).ifPresent(getFrame()::add);
        getFrame().validate();
        getFrame().repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public SwingPanel getSwingPanel() {
        return this.panel;
    }
}
