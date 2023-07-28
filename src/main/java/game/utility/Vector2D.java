package game.utility;

/** class to represent a point, speed or acceleration in 2D space. */
public class Vector2D {
    private final double x;
    private final double y;

    /**
     * constructor with all parameters.
     * 
     * @param x : orizontal coordinate
     * @param y : vertical coordinate
     */
    public Vector2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /** @return x coordinate */
    public double getX() {
        return x;
    }

    /** @return y coordinate */
    public double getY() {
        return y;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Vector2D [x=" + x + ", y=" + y + "]";
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
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
        final Vector2D other = (Vector2D) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }

}
