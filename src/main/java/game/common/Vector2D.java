package game.common;

public class Vector2D {
    private double x;
    private double y;

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

    public void setX(final double x) {
        this.x = x;
    }

    public void setY(final double y) {
        this.y = y;
    }

    // inherited from Object

    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }

}
