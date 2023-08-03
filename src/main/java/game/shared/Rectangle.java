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
    private final double positionX;
    private final double positionY;
    private final double sizeX;
    private final double sizeY;

    public Rectangle(final double positionX, final double positionY, final double sizeX, final double sizeY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(positionX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(positionY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sizeX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sizeY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(positionX) != Double.doubleToLongBits(other.positionX)) {
            return false;
        }
        if (Double.doubleToLongBits(positionY) != Double.doubleToLongBits(other.positionY)) {
            return false;
        }
        if (Double.doubleToLongBits(sizeX) != Double.doubleToLongBits(other.sizeX)) {
            return false;
        }
        return (Double.doubleToLongBits(sizeY) == Double.doubleToLongBits(other.sizeY));
    }

    @Override
    public String toString() {
        return "Rectangle [positionX=" + positionX
                + ", positionY=" + positionY
                + ", sizeX=" + sizeX
                + ", sizeY=" + sizeY + "]";
    }

}
