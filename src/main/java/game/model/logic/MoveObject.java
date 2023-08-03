package game.model.logic;

import game.model.entity.GameObject;
import game.shared.Rectangle;

public class MoveObject {
    public void moveObject(final GameObject object, final Rectangle newPosition) {
        object.setPosition(newPosition);

        // ADD COLLISION LOGIC
    }
}
