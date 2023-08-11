package game.view.renderer;

import game.model.entity.GameWorld;
import game.utility.ProgressiveTime;
import game.view.input.InputHandler;

public interface Window {

    void start();

    void update(ProgressiveTime elapsedTime);

    void executeStoredActions(ProgressiveTime elapsedTime, GameWorld gameWorld);

    void addInputHandler(InputHandler inputHandler);
}
