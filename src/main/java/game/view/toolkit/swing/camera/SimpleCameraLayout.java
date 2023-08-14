package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;

/** @deprecated: use TilingCameraLayout */
@Deprecated
public class SimpleCameraLayout extends AbstractCameraLayout {
    private final Type type;

    public SimpleCameraLayout(final Type type) {
        this.type = type;
    }

    public enum Type {
        VERTICAL,
        ORIZONTAL,
        BEST_FIT;
    }

    @Override
    public void draw(final Graphics drawer, final List<GameObject> objects, final GameWorld world) {
        final double bw = BORDER_WIDTH;
        final double widthTot = drawer.getClipBounds().getWidth();
        final double heightTot = drawer.getClipBounds().getHeight();
        final double widthTotBorder = widthTot - (BORDER_WIDTH * (objects.size() + 1));
        final double heightTotBorder = heightTot - (BORDER_WIDTH * (objects.size() + 1));
        final double width = widthTotBorder / objects.size();
        final double height = heightTotBorder / objects.size();

        // split and draw (template method)
        IntStream.range(0, objects.size()).forEach(i -> {
            final var offset = (i + 1) * bw;
            final var orizRect = new Rectangle(bw, (height * i) + offset, widthTot - 2 * bw, height);
            final var vertRect = new Rectangle((width * i) + offset, bw, width, heightTot - 2 * bw);
            final var rectangle = switch (this.type) {
                case VERTICAL -> vertRect;
                case ORIZONTAL -> orizRect;
                case BEST_FIT -> width > height ? vertRect : orizRect;
                default -> vertRect;
            };
            CAMERA.draw(rectangle, drawer, world, objects.get(i));
        });
    }
}
