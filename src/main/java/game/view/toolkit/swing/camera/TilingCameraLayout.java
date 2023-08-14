package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;

public class TilingCameraLayout extends AbstractCameraLayout {
    private final Layout layout;

    public TilingCameraLayout(final Layout layout) {
        this.layout = layout;
    }

    public enum Layout {
        VERTICAL,
        ORIZONTAL,
        VERT_ORIZ,
        SQUARE, 
        OPTIMAL; 
    }

    @Override
    protected void draw(final Graphics drawer, final List<GameObject> objects, final GameWorld world) {
        final Rectangle borderLessRect = removeBorders(SWING_UTIL.convertRectangle(drawer.getClipBounds()));

        final List<Rectangle> areas = switch (this.layout) {
            case VERTICAL -> splitOrizontallyWithBorders(borderLessRect, objects.size());
            case ORIZONTAL -> splitVerticallyWithBorders(borderLessRect, objects.size());
            case VERT_ORIZ -> splitVertOrizWithBorder(borderLessRect, objects.size());
            // TODO implement all cases
            default -> throw new UnsupportedOperationException(this.layout + " layout not supported!");
        };

        IntStream.range(0, objects.size()).forEach(i -> CAMERA.draw(areas.get(i), drawer, world, objects.get(i)));
    }
}
