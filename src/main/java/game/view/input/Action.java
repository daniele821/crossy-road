package game.view.input;

import game.utility.Vector2D;

public interface Action {
    int getObjectId();

    Vector2D getMovement();
}
