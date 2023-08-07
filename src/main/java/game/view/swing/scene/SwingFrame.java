package game.view.swing.scene;

import javax.swing.JFrame;

public class SwingFrame extends JFrame {
    private static final long serialVersionUID = -1492508066498442465L;

    public SwingFrame() {
        setTitle("Crossy-Road");
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
