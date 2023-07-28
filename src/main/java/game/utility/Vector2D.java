package game.utility;

public class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }

}
