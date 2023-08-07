package game.view.input;

import java.util.Optional;

public interface InputHandler {
    Optional<Action> getStoredAction();

    void storeAction(Action action);
}
