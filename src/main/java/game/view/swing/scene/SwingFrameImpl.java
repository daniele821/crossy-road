package game.view.swing.scene;

import java.util.Optional;

import javax.swing.JFrame;

public class SwingFrameImpl extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;
    private Optional<SwingPanel> panel;

    public SwingFrameImpl() {
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
        this.panel.map(SwingPanel::getPanel).ifPresent(getFrame()::remove);
        Optional.ofNullable(panel).map(SwingPanel::getPanel).ifPresent(getFrame()::add);
        getFrame().repaint();
        getFrame().validate();
    }

    @Override
    public Optional<SwingPanel> getSwingPanel() {
        return this.panel;
    }
}
