package game.utility;

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
    public String toString() {
        return "Rectangle [positionX=" + positionX + ", positionY=" + positionY + ", sizeX=" + sizeX + ", sizeY="
                + sizeY + "]";
    }

}
