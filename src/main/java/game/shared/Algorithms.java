package game.shared;

import java.util.Optional;

public class Algorithms {
    public Optional<Rectangle> getIntersection(final Rectangle rect1, final Rectangle rect2) {
        final double left1 = rect1.getPositionX();
        final double right1 = rect1.getPositionX() + rect1.getSizeX();
        final double left2 = rect2.getPositionX();
        final double right2 = rect2.getPositionX() + rect2.getSizeX();
        final double maxLeft = Double.max(left1, left2);
        final double minRight = Double.min(right1, right2);
        if (maxLeft > minRight) {
            return Optional.empty();
        }

        final double up1 = rect1.getPositionY();
        final double down1 = rect1.getPositionY() + rect1.getSizeY();
        final double up2 = rect2.getPositionY();
        final double down2 = rect2.getPositionY() + rect2.getSizeY();
        final double maxUp = Double.max(up1, up2);
        final double minDown = Double.min(down1, down2);
        if (maxUp > minDown) {
            return Optional.empty();
        }

        return Optional.of(new Rectangle(maxLeft, maxUp, minRight - maxLeft, minDown - maxUp));
    }
}
