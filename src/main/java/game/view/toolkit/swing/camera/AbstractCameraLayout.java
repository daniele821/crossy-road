package game.view.toolkit.swing.camera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.model.entity.util.GameWorldUtil;
import game.model.entity.util.GameWorldUtilImpl;
import game.utility.Algorithms;
import game.utility.Rectangle;
import game.view.toolkit.swing.SwingAlgorithms;

public abstract class AbstractCameraLayout implements CameraLayout {
    protected static final GameWorldUtil WORLD_UTIL = new GameWorldUtilImpl();
    protected static final Algorithms ALGORITHMS = new Algorithms();
    protected static final SwingAlgorithms SWING_UTIL = new SwingAlgorithms();
    protected static final Color BORDER_COLOR = Color.DARK_GRAY;
    protected static final int BORDER_WIDTH = 10;
    private Camera camera;

    public AbstractCameraLayout(final Camera camera) {
        this.camera = Optional.ofNullable(camera).orElseThrow();
    }

    protected abstract void draw(Graphics drawer, List<GameObject> objects, GameWorld world);

    @Override
    public final void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        if (objectId.stream().filter(id -> !WORLD_UTIL.isObjectIdValid(id, world)).count() != 0) {
            throw new IllegalArgumentException("objectId (" + objectId + ") is not valid!");
        }

        // set background color
        final Color oldColor = drawer.getColor();
        drawer.setColor(BORDER_COLOR);
        drawer.fillRect(0, 0, (int) drawer.getClipBounds().getWidth(), (int) drawer.getClipBounds().getHeight());

        // actual draw
        draw(drawer, getPresentObjects(objectId, world), world);

        // restore color
        drawer.setColor(oldColor);
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
        final double bw = BORDER_WIDTH;
        return IntStream.range(0, n)
                .mapToObj(i -> new Rectangle(width * i + (i + 1) * bw, area.getY(), width, area.getLenY()))
                .toList();
    }

    protected List<Rectangle> splitOrizontallyWithBorders(final Rectangle area, final int n) {
        final double heightTot = area.getLenY();
        final double heightTotBorder = heightTot - (n - 1) * BORDER_WIDTH;
        final double height = heightTotBorder / n;
        final double bw = BORDER_WIDTH;
        return IntStream.range(0, n)
                .mapToObj(i -> new Rectangle(area.getX(), height * i + (i + 1) * bw, area.getLenX(), height))
                .toList();
    }

    protected List<Rectangle> splitVertOrizWithBorder(final Rectangle area, final int n) {
        final Supplier<List<Rectangle>> orizontal = () -> splitOrizontallyWithBorders(area, n);
        final Supplier<List<Rectangle>> vertical = () -> splitVerticallyWithBorders(area, n);
        return area.getLenX() > area.getLenY() ? vertical.get() : orizontal.get();
    }

    protected List<GameObject> getPresentObjects(final List<Integer> objectId, final GameWorld world) {
        return objectId.stream().map(id -> WORLD_UTIL.getPresentObject(id, world)).flatMap(Optional::stream).toList();
    }

    protected Camera getCamera() {
        return this.camera;
    }

    @Override
    public void setCamera(final Camera camera) {
        this.camera = Optional.ofNullable(camera).orElseThrow();
    }
}
