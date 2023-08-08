package game.view.swing.scene;

import javax.swing.JFrame;

public class SwingFrameImpl extends JFrame implements SwingFrame {
    private static final long serialVersionUID = -1492508066498442465L;

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
}
