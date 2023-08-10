package game.view.swing.panel;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.view.swing.action.SwingAction;
import game.view.swing.frame.SwingFrame;

public abstract class AbstractSwingPanel extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private transient Optional<SwingFrame> frame = Optional.empty();
    private transient int actionId;

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public SwingFrame getFrame() {
        return this.frame.get();
    }

    @Override
    public void setFrame(final SwingFrame frame) {
        this.frame = Optional.ofNullable(frame);
    }

    @Override
    public void putAction(final List<KeyStroke> keyStrokes, final SwingAction swingAction) {
        final var actionId = ++this.actionId;
        final var inputMap = getPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        final var actionMap = getPanel().getActionMap();
        keyStrokes.forEach(key -> inputMap.put(key, actionId));
        actionMap.put(actionId, new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                swingAction.actionPerformed(event);
            }
        });
    }

    @Override
    public void clearActions() {
        this.actionId = 0;
        getPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).clear();
        getPanel().getActionMap().clear();
    }

}
