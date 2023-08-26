package game.utility;

public class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    // getters

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // modifiers

    public Vector2D modifyX(final double x) {
        return new Vector2D(x, y);
    }

    public Vector2D modifyY(final double y) {
        return new Vector2D(x, y);
    }

    // inherited from Object

    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }

}
