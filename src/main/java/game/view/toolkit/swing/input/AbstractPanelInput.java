package game.view.toolkit.swing.input;

import java.util.List;

import javax.swing.KeyStroke;

import game.view.toolkit.swing.frame.SwingFrame;

public abstract class AbstractPanelInput implements PanelInput {
    private final SwingFrame frame;

    protected AbstractPanelInput(final SwingFrame swingFrame) {
        this.frame = swingFrame;
    }

    protected SwingFrame getSwingFrame() {
        return this.frame;
    }

    protected KeyStroke getKeyStroke(final int keyEvent) {
        return KeyStroke.getKeyStroke(keyEvent, 0);
    }

    protected List<KeyStroke> getKeyStrokes(final int keyEvent) {
        return getKeyStrokes(List.of(keyEvent));
    }

    protected List<KeyStroke> getKeyStrokes(final List<Integer> keyEvent) {
        return keyEvent.stream().map(this::getKeyStroke).toList();
    }
}
