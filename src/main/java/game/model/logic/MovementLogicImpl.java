package game.model.logic;

import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class MovementLogicImpl implements MovementLogic {
    @Override
    public Optional<Rectangle> wrapAround(final GameWorld world, final GameObject object, final Rectangle newPos) {
        final Optional<Vector2D> wrapper = object.getWraparoundDelta();
        final Rectangle worldSize = world.getGameWorldInfo().getWorldBounds();
        final double leftDelta = worldSize.getX() - newPos.getX();
        final double rightDelta = (newPos.getX() + newPos.getLenX()) - (worldSize.getX() + worldSize.getLenX());
        final double topDelta = worldSize.getY() - newPos.getY();
        final double downDelta = (newPos.getY() + newPos.getLenY()) - (worldSize.getY() + worldSize.getLenY());
        final double speedX = object.getSpeed().getX();
        final double speedY = object.getSpeed().getY();

        if (wrapper.isEmpty()) {
            if ((leftDelta > 0 && speedX <= 0) || (rightDelta > 0 && speedX >= 0)) {
                return Optional.ofNullable(object.getPosition());
            }
            if ((topDelta > 0 && speedY <= 0) || (downDelta > 0 && speedY >= 0)) {
                return Optional.ofNullable(object.getPosition());
            }
            return Optional.empty();
        }

        final double wrapX = Double.max(0, wrapper.get().getX());
        final double wrapY = Double.max(0, wrapper.get().getY());
        double x = newPos.getX();
        double y = newPos.getY();
        if (leftDelta > wrapX + newPos.getLenX()) {
            x = worldSize.getX() + worldSize.getLenX();
        }
        if (rightDelta > wrapX + newPos.getLenX()) {
            x = worldSize.getX() - newPos.getLenX();
        }
        if (topDelta > wrapY + newPos.getLenY()) {
            y = worldSize.getY() + worldSize.getLenY();
        }
        if (downDelta > wrapY + newPos.getLenY()) {
            y = worldSize.getY() - newPos.getLenY();
        }
        return Optional.ofNullable(new Rectangle(x, y, newPos.getLenX(), newPos.getLenY()));
    }

    @Override
    public boolean canMove(final GameWorld world, final int objectId, final GameObject object, final Rectangle newPos) {
        // TODO
        return true;
    }

    @Override
    public void postMove(final GameWorld world, final int objectId, final GameObject object, final Rectangle newPos) {
        // TODO
    }

}
