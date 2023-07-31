package game.shared;

import java.util.Optional;

public class Algorithms {
    public Optional<Rectangle> getIntersection(final Rectangle rect1, final Rectangle rect2) {
        final double left1 = rect1.getPositionX();
        final double right1 = rect1.getPositionX() + rect1.getSizeX();
        final double left2 = rect2.getPositionX();
        final double right2 = rect2.getPositionX() + rect2.getSizeX();
        final double maxLeft = Double.max(left1, left2);
        final double minRight = Double.min(right1, right2);
        if (maxLeft > minRight) {
            return Optional.empty();
        }

        final double up1 = rect1.getPositionY();
        final double down1 = rect1.getPositionY() + rect1.getSizeY();
        final double up2 = rect2.getPositionY();
        final double down2 = rect2.getPositionY() + rect2.getSizeY();
        final double maxUp = Double.max(up1, up2);
        final double minDown = Double.min(down1, down2);
        if (maxUp > minDown) {
            return Optional.empty();
        }

        return Optional.of(new Rectangle(maxLeft, maxUp, minRight - maxLeft, minDown - maxUp));
    }

    public Vector2D add(final Vector2D vect1, Vector2D vect2) {
        return new Vector2D(vect1.getX() + vect2.getX(), vect1.getY() + vect2.getY());
    }

    public Rectangle add(final Rectangle pos, final Vector2D move) {
        return new Rectangle(
                pos.getPositionX() + move.getX(),
                pos.getPositionY() + move.getY(),
                pos.getSizeX(),
                pos.getSizeY());
    }

    public Vector2D multiply(final Vector2D vector, final double factor) {
        return new Vector2D(vector.getX() * factor, vector.getY() * factor);
    }

}
