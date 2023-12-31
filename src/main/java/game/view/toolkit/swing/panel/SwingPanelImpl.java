package game.view.toolkit.swing.panel;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.view.toolkit.swing.frame.SwingFrame;
import game.view.toolkit.swing.input.AllPanelInput;
import game.view.toolkit.swing.input.SwingAction;

public class SwingPanelImpl implements SwingPanel {
    private final Optional<JPanel> panel = Optional.ofNullable(new JPanel());
    private Optional<SwingFrame> frame = Optional.empty();
    private int actionId;

    @Override
    public void start() {
        new AllPanelInput(getSwingFrame()).getActions(null, null).forEach(this::putAction);
    }

    @Override
    public void destroy() {
        clearActions();
    }

    @Override
    public JPanel getJPanel() {
        return this.panel.get();
    }

    @Override
    public SwingFrame getSwingFrame() {
        return this.frame.get();
    }

    @Override
    public void setSwingFrame(final SwingFrame frame) {
        this.frame = Optional.ofNullable(frame);
    }

    @Override
    public void putAction(final List<KeyStroke> keyStrokes, final SwingAction swingAction) {
        final var actionId = ++this.actionId;
        final var inputMap = getJPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        final var actionMap = getJPanel().getActionMap();
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
        getJPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).clear();
        getJPanel().getActionMap().clear();
    }

}
