package game.common.util;

import game.common.Rectangle;

public final class Rectangles {

    private Rectangles() {
    }

    // algrebric operations

    public static Rectangle multiplyScalar(final double factor, final Rectangle rect) {
        final double x = factor * rect.getX();
        final double y = factor * rect.getY();
        final double lenX = factor * rect.getLenX();
        final double lenY = factor * rect.getLenY();
        return new Rectangle(x, y, lenX, lenY);
    }
}
