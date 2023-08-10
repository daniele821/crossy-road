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
    public void putAction(final KeyStroke keyStroke, final List<SwingAction> swingAction) {
        getPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, ++this.actionId);
        swingAction.forEach(action -> {
            getPanel().getActionMap().put(this.actionId, new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent actionEvent) {
                    action.actionPerformed(actionEvent);
                }
            });
        });
    }

    @Override
    public void clearActions() {
        this.actionId = 0;
        getPanel().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).clear();
        getPanel().getActionMap().clear();
    }

}
