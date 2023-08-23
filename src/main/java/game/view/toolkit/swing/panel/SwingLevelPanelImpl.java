package game.view.toolkit.swing.panel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import game.model.entity.GameWorldLevel;
import game.utility.Pair;

public class SwingLevelPanelImpl extends SwingPanelImpl implements SwingLevelPanel {
    private final List<Pair<GameWorldLevel, JButton>> levelButtons = new ArrayList<>();
    private final JButton quitButton = new JButton("QUIT");

    @Override
    public void start() {
        super.start();

        quitButton.addActionListener(e -> getSwingFrame().closeApplication());
        getJPanel().add(quitButton);

        Arrays.asList(GameWorldLevel.values()).stream()
                .map(level -> new Pair<>(level, new JButton(level.getLevelName())))
                .peek(this::addActionListener)
                .peek(levelButtons::add)
                .map(Pair::getB)
                .forEach(getJPanel()::add);
    }

    private void addActionListener(final Pair<GameWorldLevel, JButton> pair) {
        pair.getB().addActionListener(e -> {
            getSwingFrame().loadMap(pair.getA());
            getSwingFrame().setSwingPanel(new SwingGamePanelImpl());
        });
    }

}
