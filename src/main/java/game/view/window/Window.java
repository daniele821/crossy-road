package game.view.window;

import game.utility.ProgressiveTime;

public interface Window extends WindowInput {
    void update(ProgressiveTime elapsedTime);
}
