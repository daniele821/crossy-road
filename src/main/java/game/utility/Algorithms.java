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

    public Optional<Rectangle> getIntersection(final GameObject obj1, final GameObject obj2) {
        return getIntersection(obj1.getPosition(), obj2.getPosition());
    }

    public Vector2D add(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.getX() + vect2.getX(), vect1.getY() + vect2.getY());
    }

    public Rectangle add(final Rectangle pos, final Vector2D move) {
        return new Rectangle(pos.getX() + move.getX(), pos.getY() + move.getY(), pos.getLenX(), pos.getLenY());
    }

    public Rectangle add(final Rectangle rect1, final Rectangle rect2) {
        final double x = rect1.getX() + rect2.getX();
        final double y = rect1.getY() + rect2.getY();
        final double lenX = rect1.getLenX() + rect2.getLenX();
        final double lenY = rect1.getLenY() + rect2.getLenY();
        return new Rectangle(x, y, lenX, lenY);
    }

    public Vector2D multiply(final Vector2D vector, final double factor) {
        return new Vector2D(vector.getX() * factor, vector.getY() * factor);
    }

    public Rectangle multiply(final Rectangle rect, final double scale) {
        return new Rectangle(rect.getX() * scale, rect.getY() * scale, rect.getLenX() * scale, rect.getLenY() * scale);
    }

    public Vector2D multiplyMembers(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.getX() * vect2.getX(), vect1.getY() * vect2.getY());
    }

    public Vector2D moveVector(final Vector2D speed, final ProgressiveTime elapsedTime) {
        return multiply(speed, (double) elapsedTime.getDeltaTime() / 1000.0);
    }

    public Vector2D moveVector(final GameObject obj, final ProgressiveTime elapsedTime) {
        return moveVector(obj.getSpeed(), elapsedTime);
    }

    @Override
    public String toString() {
        return "Algorithms []";
    }

}
