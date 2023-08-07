package game.view.input;

import java.util.Optional;

public class InputHandlerImpl implements InputHandler {
    private Optional<Action> storedAction = Optional.empty();

    @Override
    public Optional<Action> getStoredAction() {
        final var storedAction = this.storedAction;
        this.storedAction = Optional.empty();
        return storedAction;
    }

    @Override
    public void storeAction(final Action action) {
        this.storedAction = Optional.ofNullable(action);
    }

}
