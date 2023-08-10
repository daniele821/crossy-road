package game.view.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.entity.GameWorld;
import game.model.logic.GameLogic;
import game.model.logic.GameLogicImpl;
import game.utility.ProgressiveTime;
import game.view.input.InputHandler;

public abstract class AbstractWindow implements Window {
    private final GameLogic gameLogic = new GameLogicImpl();
    private final List<InputHandler> inputHandlers = new ArrayList<>();

    @Override
    public void executeStoredActions(final ProgressiveTime elapsedTime, final GameWorld gameWorld) {
        this.inputHandlers.stream()
                .map(InputHandler::getStoredAction)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(action -> gameLogic.moveObject(action.getObjectId(), action.getMovement(), gameWorld));
    }

    protected void addInputHandler(final InputHandler inputHandler) {
        this.inputHandlers.add(inputHandler);
    }

    protected void clearInputHandlers() {
        this.inputHandlers.clear();
    }
}
