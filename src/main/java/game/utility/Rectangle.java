package game.utility;

public class Rectangle {
    private final double x;
    private final double y;
    private final double lenX;
    private final double lenY;

    public Rectangle(final double x, final double y, final double lenX, final double lenY) {
        this.x = x;
        this.y = y;
        this.lenX = lenX;
        this.lenY = lenY;
    }

    public Rectangle(final Vector2D pos, final double lenX, final double lenY) {
        this(pos.getX(), pos.getY(), lenX, lenY);
    }

    public Rectangle(final double x, final double y, final Vector2D size) {
        this(x, y, size.getX(), size.getY());
    }

    public Rectangle(final Vector2D pos, final Vector2D size) {
        this(pos.getX(), pos.getY(), size.getX(), size.getY());
    }

    // getters

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLenX() {
        return lenX;
    }

    public double getLenY() {
        return lenY;
    }

    public Vector2D getFirstPoint() {
        return new Vector2D(x, y);
    }

    public Vector2D getSize() {
        return new Vector2D(lenX, lenY);
    }

    // modifiers

    public Rectangle modifyX(final double x) {
        return new Rectangle(x, y, lenX, lenY);
    }

    public Rectangle modifyY(final double y) {
        return new Rectangle(x, y, lenX, lenY);
    }

    public Rectangle modifyLenX(final double lenX) {
        return new Rectangle(x, y, lenX, lenY);
    }

    public Rectangle modifyLenY(final double lenY) {
        return new Rectangle(x, y, lenX, lenY);
    }

    public Rectangle modifyPos(final Vector2D pos) {
        return new Rectangle(pos.getX(), pos.getY(), lenX, lenY);
    }

    public Rectangle modifySize(final Vector2D size) {
        return new Rectangle(x, y, size.getX(), size.getY());
    }

    // calculations

    public double getSecondX() {
        return x + lenX;
    }

    public double getSecondY() {
        return y + lenY;
    }

    public Vector2D getSecondPoint() {
        return new Vector2D(x + lenX, y + lenY);
    }

    // inherited from Object

    @Override
    public String toString() {
        return "Rectangle [x=" + x + ", y=" + y + ", lenX=" + lenX + ", lenY=" + lenY + "]";
    }

}
