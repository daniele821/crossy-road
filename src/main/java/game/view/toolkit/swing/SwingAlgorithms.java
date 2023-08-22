package game.view.toolkit.swing;

import game.utility.Rectangle;

public class SwingAlgorithms {
    public Rectangle convertRectangle(final java.awt.Rectangle rect) {
        return new Rectangle(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public java.awt.Rectangle convertRectangle(final Rectangle rect) {
        return new java.awt.Rectangle((int) rect.getX(), (int) rect.getY(), (int) rect.getLenX(), (int) rect.getLenY());
    }
}
