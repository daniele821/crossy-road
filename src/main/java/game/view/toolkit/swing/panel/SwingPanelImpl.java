package game.view.toolkit.swing.panel;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.view.toolkit.swing.action.SwingAction;
import game.view.toolkit.swing.frame.SwingFrame;

public class SwingPanelImpl extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private transient Optional<SwingFrame> frame = Optional.empty();
    private transient int actionId;

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public JPanel getJPanel() {
        return this;
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
