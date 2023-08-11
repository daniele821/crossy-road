package game.view.toolkit.swing.panel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import game.model.entity.GameWorldLevel;
import game.utility.Pair;

public class SwingLevelPanelImpl extends SwingPanelImpl implements SwingLevelPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private static final List<Pair<GameWorldLevel, JButton>> LEVEL_BUTTONS = new ArrayList<>();
    private static final JButton QUIT_BUTTON = new JButton("QUIT");

    @Override
    public void start() {
        super.start();

        QUIT_BUTTON.addActionListener(e -> getSwingFrame().closeApplication());
        getJPanel().add(QUIT_BUTTON);

        Arrays.asList(GameWorldLevel.values()).stream()
                .map(level -> new Pair<>(level, new JButton(level.getLevelName())))
                .peek(this::addActionListener)
                .peek(LEVEL_BUTTONS::add)
                .map(Pair::getB)
                .forEach(getJPanel()::add);
    }

    private void addActionListener(final Pair<GameWorldLevel, JButton> pair) {
        getSwingFrame().loadMap(pair.getA());
        pair.getB().addActionListener(e -> getSwingFrame().setSwingPanel(new SwingGamePanelImpl()));
    }

}
