package game.view.toolkit.swing.input;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import javax.swing.KeyStroke;

import game.model.entity.GameWorld;
import game.view.toolkit.swing.frame.SwingFrame;

public class AllPanelInput extends AbstractPanelInput {
    public AllPanelInput(final SwingFrame swingFrame) {
        super(swingFrame);
    }

    @Override
    public Map<List<KeyStroke>, SwingAction> getActions(final GameWorld world, final List<Integer> players) {
        final SwingAction closeAction = e -> getSwingFrame().closeApplication();
        return Map.of(getKeyStrokes(KeyEvent.VK_ESCAPE), closeAction);
    }

}
