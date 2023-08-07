package game.view.input;

import game.utility.Vector2D;

public class ActionImpl implements Action {
    private final int objectId;
    private final Vector2D movement;

    public ActionImpl(final int objectId, final Vector2D movement) {
        this.objectId = objectId;
        this.movement = movement;
    }

    @Override
    public int getObjectId() {
        return this.objectId;
    }

    @Override
    public Vector2D getMovement() {
        return this.movement;
    }

}
