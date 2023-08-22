package game.view.toolkit.swing.input;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.KeyStroke;

import game.view.toolkit.swing.action.SwingAction;
import game.view.toolkit.swing.frame.SwingFrame;

public class AllPanelsInput extends AbstractPanelInput {
    private final Optional<SwingFrame> swingFrame;

    public AllPanelsInput(final SwingFrame swingFrame) {
        this.swingFrame = Optional.ofNullable(swingFrame);
    }

    @Override
    public Map<List<KeyStroke>, SwingAction> getActions() {
        final SwingAction closeAction = e -> this.swingFrame.get().closeApplication();
        return Map.of(getKeyStrokes(KeyEvent.VK_ESCAPE), closeAction);
    }

}
