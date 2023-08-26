package game.common;

public class Rectangle {
    private double x;
    private double y;
    private double lenX;
    private double lenY;

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

    public void setX(final double x) {
        this.x = x;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public void setLenX(final double lenX) {
        this.lenX = lenX;
    }

    public void setLenY(final double lenY) {
        this.lenY = lenY;
    }

    public void setPos(final Vector2D pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public void setSize(final Vector2D size) {
        this.lenX = size.getX();
        this.lenY = size.getY();
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
