package game.view.swing.scene.panel;

import javax.swing.JPanel;

public abstract class AbstractSwingPanel extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;

    @Override
    public JPanel getPanel() {
        return this;
    }

}
