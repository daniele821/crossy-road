package game.view.toolkit.swing.input;

import java.util.List;
import java.util.Map;

import javax.swing.KeyStroke;

import game.model.entity.GameWorld;

public interface PanelInput {
    Map<List<KeyStroke>, SwingAction> getActions(GameWorld world, List<Integer> players);
}
