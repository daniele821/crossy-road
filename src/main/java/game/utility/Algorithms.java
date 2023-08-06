package game.utility;

import java.util.Optional;

import game.model.entity.GameObject;

public class Algorithms {
    public Optional<Rectangle> getIntersection(final Rectangle rect1, final Rectangle rect2) {
        final double maxLeft = Double.max(rect1.getX(), rect2.getX());
        final double minRight = Double.min(rect1.getX() + rect1.getLenX(), rect2.getX() + rect2.getLenX());
        if (maxLeft > minRight) {
            return Optional.empty();
        }

        final double maxUp = Double.max(rect1.getY(), rect2.getY());
        final double minDown = Double.min(rect1.getY() + rect1.getLenY(), rect2.getY() + rect2.getLenY());
        if (maxUp > minDown) {
            return Optional.empty();
        }

        return Optional.of(new Rectangle(maxLeft, maxUp, minRight - maxLeft, minDown - maxUp));
    }

    public Vector2D add(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.x + vect2.x, vect1.y + vect2.y);
    }

    public Rectangle add(final Rectangle pos, final Vector2D move) {
        return new Rectangle(pos.getX() + move.x, pos.getY() + move.y, pos.getLenX(), pos.getLenY());
    }

    public Vector2D multiply(final Vector2D vector, final double factor) {
        return new Vector2D(vector.x * factor, vector.y * factor);
    }

    public Vector2D multiplyMembers(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.x * vect2.x, vect1.y * vect2.y);
    }

    public Rectangle move(final Rectangle rect, final Vector2D speed, final ProgressiveTime elapsedTime) {
        return add(rect, multiply(speed, (double) elapsedTime.getDeltaTime() / 1000.0));
    }

    public Rectangle move(final GameObject obj, final ProgressiveTime elapsedTime) {
        return move(obj.getPosition(), obj.getSpeed(), elapsedTime);
    }

    @Override
    public String toString() {
        return "Algorithms []";
    }

}