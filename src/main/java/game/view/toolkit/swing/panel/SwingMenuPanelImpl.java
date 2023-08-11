package game.view.toolkit.swing.panel;

import javax.swing.JButton;

public class SwingMenuPanelImpl extends SwingPanelImpl implements SwingMenuPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private static final JButton QUIT_BUTTON = new JButton("QUIT");
    private static final JButton LEVEL_BUTTON = new JButton("LEVEL");

    @Override
    public void start() {
        super.start();
        LEVEL_BUTTON.addActionListener(e -> getSwingFrame().setSwingPanel(new SwingLevelPanelImpl()));
        QUIT_BUTTON.addActionListener(e -> getSwingFrame().closeApplication());
        getJPanel().add(LEVEL_BUTTON);
        getJPanel().add(QUIT_BUTTON);
    }

}
