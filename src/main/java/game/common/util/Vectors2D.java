package game.common.util;

import game.common.Vector2D;

public final class Vectors2D {

    private Vectors2D() {
    }

    // algebric operations

    public static Vector2D multiplyScalar(final double factor, final Vector2D vect) {
        return new Vector2D(vect.getX() * factor, vect.getY() * factor);
    }

    public static Vector2D multiplyMembers(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.getX() * vect2.getX(), vect1.getY() * vect2.getY());
    }

    public static Vector2D add(final Vector2D vect1, final Vector2D vect2) {
        return new Vector2D(vect1.getX() + vect2.getX(), vect1.getY() + vect2.getY());
    }

    // speed based movement

    public static Vector2D moveVector(final Vector2D speed, final double elapsedTimeMillisec) {
        final double millisecInSec = 1000.0;
        return multiplyScalar(elapsedTimeMillisec / millisecInSec, speed);
    }
}
