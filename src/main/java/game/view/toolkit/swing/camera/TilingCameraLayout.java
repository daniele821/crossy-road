package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.ArrayList;
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
        RECT_WITH_EMPTY_SPOT,
        RECT_FILL_EMPTY_SPOT;
    }

    @Override
    protected void draw(final Graphics drawer, final List<GameObject> objects, final GameWorld world) {
        final Rectangle borderLessRect = removeBorders(SWING_UTIL.convertRectangle(drawer.getClipBounds()));
        if (borderLessRect.getLenX() <= 0 || borderLessRect.getLenY() <= 0) {
            return;
        }

        final List<Rectangle> areas = switch (this.layout) {
            case VERTICAL -> splitOrizontallyWithBorders(borderLessRect, objects.size());
            case ORIZONTAL -> splitVerticallyWithBorders(borderLessRect, objects.size());
            case VERT_ORIZ -> splitVertOrizWithBorder(borderLessRect, objects.size());
            case RECT_WITH_EMPTY_SPOT -> getAreas(borderLessRect, objects.size(), false);
            case RECT_FILL_EMPTY_SPOT -> getAreas(borderLessRect, objects.size(), true);
            default -> throw new UnsupportedOperationException(this.layout + " layout not supported!");
        };

        IntStream.range(0, objects.size()).forEach(i -> CAMERA.draw(areas.get(i), drawer, world, objects.get(i)));
    }

    private List<Rectangle> getAreas(final Rectangle area, final int n, final boolean fillEmptyAreas) {
        final double factorSides = area.getLenX() / area.getLenY();
        final double factorFixed = Double.max(1 / (double) n, Double.min(n, factorSides));
        final double num1 = Math.sqrt((double) n / factorFixed);
        final double num2 = (double) n / num1;
        final int min = (int) Math.round(Double.min(num1, num2));
        final int max = (n / min) * min < n ? n / min + 1 : n / min;
        final int vert = num1 > num2 ? min : max;
        final int oriz = num1 > num2 ? max : min;
        if (!fillEmptyAreas) {
            return splitOrizontallyWithBorders(area, oriz).stream()
                    .flatMap(rect -> splitVerticallyWithBorders(rect, vert).stream())
                    .toList();
        }
        final int emptyAreas = vert * oriz - n;
        final List<Integer> nAreas = new ArrayList<>();
        IntStream.range(0, oriz).forEach(i -> {
            nAreas.add(oriz - i <= emptyAreas ? vert - 1 : vert);
        });
        return getAreas(area, nAreas);
    }

    private List<Rectangle> getAreas(final Rectangle area, final List<Integer> n) {
        final List<Rectangle> orizSplit = splitOrizontallyWithBorders(area, n.size());
        final List<Rectangle> res = new ArrayList<>();
        IntStream.range(0, n.size()).forEach(i -> {
            res.addAll(splitVerticallyWithBorders(orizSplit.get(i), n.get(i)));
        });
        return res;
    }
}
