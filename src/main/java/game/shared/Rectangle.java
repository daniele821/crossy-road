package game.shared;

//  A---B
//  |   |
//  |   |
//  |   |
//  D---C
// 
// positionX, positionY = A(x;y) 
// sizeX = B(x) - A(x)
// sizeY = D(y) - A(y)

public class Rectangle {
    public final double x;
    public final double y;
    public final double lenX;
    public final double lenY;

    public Rectangle(final double positionX, final double positionY, final double sizeX, final double sizeY) {
        this.x = positionX;
        this.y = positionY;
        this.lenX = sizeX;
        this.lenY = sizeY;
    }

    public Rectangle(final Vector2D position, final Vector2D size) {
        this(position.x, position.y, size.x, size.y);
    }

    public Vector2D getPosition() {
        return new Vector2D(this.x, this.y);
    }

    public Vector2D getSize() {
        return new Vector2D(this.x, this.y);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lenX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lenY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(lenX) != Double.doubleToLongBits(other.lenX)) {
            return false;
        }
        return Double.doubleToLongBits(lenY) == Double.doubleToLongBits(other.lenY);
    }

    @Override
    public String toString() {
        return "Rectangle [positionX=" + x
                + ", positionY=" + y
                + ", sizeX=" + lenX
                + ", sizeY=" + lenY + "]";
    }

}
