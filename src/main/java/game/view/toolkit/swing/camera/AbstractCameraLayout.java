package game.view.toolkit.swing.camera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;

public abstract class AbstractCameraLayout implements CameraLayout {
    protected static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    protected static final Algorithms ALGORITHMS = new Algorithms();
    protected static final Camera CAMERA = new ResizableCamera();
    protected static final Color BORDER_COLOR = Color.DARK_GRAY;
    protected static final int BORDER_WIDTH = 10;

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        if (objectId.stream().filter(id -> !WORLD_UTIL.isObjectIdValid(id, world)).count() != 0) {
            throw new IllegalArgumentException("objectId (" + objectId + ") is not valid!");
        }
    }

    protected Rectangle removeBorders(final Rectangle area) {
        final double x = area.getX() + BORDER_WIDTH;
        final double y = area.getY() + BORDER_WIDTH;
        final double lenX = area.getLenX() - 2 * BORDER_WIDTH;
        final double lenY = area.getLenY() - 2 * BORDER_WIDTH;
        return new Rectangle(x, y, lenX, lenY);
    }

    protected List<Rectangle> splitVerticallyWithBorders(final Rectangle area, final int n) {
        final double widthTot = area.getLenX();
        final double widthTotBorder = widthTot - (n - 1) * BORDER_WIDTH;
        final double width = widthTotBorder / n;
        return IntStream.range(0, n)
                .mapToObj(i -> new Rectangle(width * i, area.getY(), width, area.getLenY()))
                .toList();
    }

    protected List<Rectangle> splitOrizontallyWithBorders(final Rectangle area, final int n) {
        final double heightTot = area.getLenY();
        final double heightTotBorder = heightTot - (n - 1) * BORDER_WIDTH;
        final double height = heightTotBorder / n;
        return IntStream.range(0, n)
                .mapToObj(i -> new Rectangle(area.getX(), height * i, area.getLenX(), height))
                .toList();
    }
}
