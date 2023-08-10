package game.view.toolkit.swing.frame;

import java.awt.Toolkit;
import java.util.Optional;

import javax.swing.JFrame;

import game.view.toolkit.swing.panel.SwingPanel;
import game.view.toolkit.swing.window.SwingWindow;

public class SwingFrameImpl extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;
    private transient Optional<SwingPanel> panel = Optional.empty();
    private transient Optional<SwingWindow> window = Optional.empty();

    @Override
    public void start() {
        setTitle("Crossy-Road");
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void updateRenderer() {
        getJFrame().validate();
        getJFrame().repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public JFrame getJFrame() {
        return this;
    }

    @Override
    public SwingPanel getSwingPanel() {
        return this.panel.get();
    }

    @Override
    public void setSwingPanel(final SwingPanel panel) {
        this.panel.map(SwingPanel::getJPanel).ifPresent(getJFrame()::remove);
        this.panel.ifPresent(panelTmp -> panelTmp.destroy());
        this.panel = Optional.ofNullable(panel);
        this.panel.ifPresent(panelTmp -> panelTmp.setSwingFrame(this));
        this.panel.map(SwingPanel::getJPanel).ifPresent(getJFrame()::add);
        this.panel.ifPresent(SwingPanel::start);
        updateRenderer();
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
