package game.utility;

/** class to represent a rectangle shape in 2D space. */
public class Rectangle {
    private final double positionX;
    private final double positionY;
    private final double sizeX;
    private final double sizeY;

    /**
     * constructor with all parameters.
     * 
     * @param positionX : topLeft corner x coordinate
     * @param positionY : topLeft corner y coordinate
     * @param sizeX     : orizontal length
     * @param sizeY     : vertical length
     */
    public Rectangle(final double positionX, final double positionY, final double sizeX, final double sizeY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /** @return topLeft corner x coordinate */
    public double getPositionX() {
        return positionX;
    }

    /** @return topLeft corner y coordinate */
    public double getPositionY() {
        return positionY;
    }

    /** @return orizontal length */
    public double getSizeX() {
        return sizeX;
    }

    /** @return vertical length */
    public double getSizeY() {
        return sizeY;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Rectangle [positionX=" + positionX + ", positionY=" + positionY + ", sizeX=" + sizeX + ", sizeY="
                + sizeY + "]";
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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
        if (Double.doubleToLongBits(positionX) != Double.doubleToLongBits(other.positionX)) {
            return false;
        }
        if (Double.doubleToLongBits(positionY) != Double.doubleToLongBits(other.positionY)) {
            return false;
        }
        if (Double.doubleToLongBits(sizeX) != Double.doubleToLongBits(other.sizeX)) {
            return false;
        }
        return Double.doubleToLongBits(sizeY) == Double.doubleToLongBits(other.sizeY);
    }

}
