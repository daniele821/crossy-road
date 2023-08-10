package game.view.swing.frame;

import java.awt.Toolkit;
import java.util.Optional;

import javax.swing.JFrame;

import game.view.swing.panel.SwingPanel;
import game.view.swing.window.SwingWindow;

public class SwingFrameImpl extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;
    private transient Optional<SwingPanel> panel = Optional.empty();
    private transient Optional<SwingWindow> window = Optional.empty();

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
    public SwingPanel getSwingPanel() {
        return this.panel.get();
    }

    @Override
    public void setSwingPanel(final SwingPanel panel) {
        this.panel.map(SwingPanel::getPanel).ifPresent(getFrame()::remove);
        this.panel.ifPresent(panelTmp -> panelTmp.destroy());
        this.panel = Optional.ofNullable(panel);
        this.panel.ifPresent(panelTmp -> panelTmp.setFrame(this));
        this.panel.map(SwingPanel::getPanel).ifPresent(getFrame()::add);
        getFrame().validate();
        getFrame().repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public SwingWindow getSwingWindow() {
        return this.window.get();
    }

    @Override
    public void setSwingWindow(final SwingWindow swingWindow) {
        this.window = Optional.ofNullable(swingWindow);
    }

}
