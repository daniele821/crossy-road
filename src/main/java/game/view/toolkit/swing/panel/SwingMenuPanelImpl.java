package game.view.toolkit.swing.panel;

import javax.swing.JButton;

public class SwingMenuPanelImpl extends SwingPanelImpl implements SwingMenuPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private final JButton quitButton = new JButton("QUIT");
    private final JButton levelButton = new JButton("LEVEL");

    @Override
    public void start() {
        super.start();
        getPanel().add(levelButton);
        getPanel().add(quitButton);
    }

}
