package game.view.swing.scene;

import javax.swing.JFrame;

public class SwingFrameImpl extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;
    private SwingPanel panel;

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
        getFrame().remove(this.panel.getPanel());
        this.panel = panel;
        getFrame().add(this.panel.getPanel());
        getFrame().validate();
        getFrame().repaint();
    }
}
