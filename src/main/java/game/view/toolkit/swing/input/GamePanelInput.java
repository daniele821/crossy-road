package game.view.toolkit.swing.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.KeyStroke;

import game.model.entity.GameWorld;
import game.utility.Algorithms;
import game.utility.Vector2D;
import game.view.input.ActionImpl;
import game.view.input.InputHandler;
import game.view.input.InputHandlerImpl;
import game.view.toolkit.swing.frame.SwingFrame;

public class GamePanelInput extends AbstractPanelInput {
    private final Algorithms algorithms = new Algorithms();
    private final Map<List<KeyStroke>, SwingAction> actions = new HashMap<>();
    private final List<Integer> players = new ArrayList<>();
    private Optional<GameWorld> world = Optional.empty();
    private int nthPlayer;

    public GamePanelInput(final SwingFrame swingFrame) {
        super(swingFrame);
    }

    private Map<List<KeyStroke>, SwingAction> copyActionsAndClear() {
        final var actionCopy = Map.copyOf(this.actions);
        this.actions.clear();
        this.players.clear();
        return actionCopy;
    }

    private void addPlayerInput(final List<KeyStroke> up, final List<KeyStroke> down,
            final List<KeyStroke> left, final List<KeyStroke> right) {
        if (this.nthPlayer >= this.players.size()) {
            return;
        }
        final int playerId = this.players.get(this.nthPlayer);
        final InputHandler inputUp = new InputHandlerImpl();
        final InputHandler inputDown = new InputHandlerImpl();
        final InputHandler inputLeft = new InputHandlerImpl();
        final InputHandler inputRight = new InputHandlerImpl();
        final Vector2D cellSize = this.world.get().getGameWorldInfo().getCellSize();
        final Vector2D upVect = algorithms.multiplyMembers(new Vector2D(0, -1), cellSize);
        final Vector2D downVect = algorithms.multiplyMembers(new Vector2D(0, 1), cellSize);
        final Vector2D leftVect = algorithms.multiplyMembers(new Vector2D(-1, 0), cellSize);
        final Vector2D rightVect = algorithms.multiplyMembers(new Vector2D(1, 0), cellSize);
        getSwingFrame().getSwingWindow().addInputHandler(inputUp);
        getSwingFrame().getSwingWindow().addInputHandler(inputDown);
        getSwingFrame().getSwingWindow().addInputHandler(inputLeft);
        getSwingFrame().getSwingWindow().addInputHandler(inputRight);
        this.actions.put(up, e -> inputUp.storeAction(new ActionImpl(playerId, upVect)));
        this.actions.put(down, e -> inputDown.storeAction(new ActionImpl(playerId, downVect)));
        this.actions.put(right, e -> inputRight.storeAction(new ActionImpl(playerId, rightVect)));
        this.actions.put(left, e -> inputLeft.storeAction(new ActionImpl(playerId, leftVect)));
        this.nthPlayer++;
    }

    private void addPlayerInput() {
        addPlayerInput(List.of(getKeyStroke(KeyEvent.VK_UP)), List.of(getKeyStroke(KeyEvent.VK_DOWN)),
                List.of(getKeyStroke(KeyEvent.VK_LEFT)), List.of(getKeyStroke(KeyEvent.VK_RIGHT)));
        addPlayerInput(List.of(getKeyStroke(KeyEvent.VK_W)), List.of(getKeyStroke(KeyEvent.VK_S)),
                List.of(getKeyStroke(KeyEvent.VK_A)), List.of(getKeyStroke(KeyEvent.VK_D)));
    }

    @Override
    public Map<List<KeyStroke>, SwingAction> getActions(final GameWorld world, final List<Integer> players) {
        this.world = Optional.ofNullable(world);
        this.players.addAll(List.copyOf(players));
        addPlayerInput();
        return copyActionsAndClear();
    }

}
