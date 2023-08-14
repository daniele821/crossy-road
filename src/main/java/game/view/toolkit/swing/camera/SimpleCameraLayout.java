package game.view.toolkit.swing.camera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;

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
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        super.draw(drawer, world, objectId);

        // variables
        final List<GameObject> presentObject = objectId.stream()
                .map(id -> WORLD_UTIL.getPresentObject(id, world))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        final double bw = BORDER_WIDTH;
        final double widthTot = drawer.getClipBounds().getWidth();
        final double heightTot = drawer.getClipBounds().getHeight();
        final double widthTotBorder = widthTot - (BORDER_WIDTH * (presentObject.size() + 1));
        final double heightTotBorder = heightTot - (BORDER_WIDTH * (presentObject.size() + 1));
        final double width = widthTotBorder / presentObject.size();
        final double height = heightTotBorder / presentObject.size();

        // set background color
        final Color oldColor = drawer.getColor();
        drawer.setColor(BORDER_COLOR);
        drawer.fillRect(0, 0, (int) widthTot, (int) heightTot);

        // split and draw (template method)
        IntStream.range(0, presentObject.size()).forEach(i -> {
            final var offset = (i + 1) * bw;
            final var orizRect = new Rectangle(bw, (height * i) + offset, widthTot - 2 * bw, height);
            final var vertRect = new Rectangle((width * i) + offset, bw, width, heightTot - 2 * bw);
            final var rectangle = switch (this.type) {
                case VERTICAL -> vertRect;
                case ORIZONTAL -> orizRect;
                case BEST_FIT -> width > height ? vertRect : orizRect;
                default -> vertRect;
            };
            CAMERA.draw(rectangle, drawer, world, presentObject.get(i));
        });

        // restore color
        drawer.setColor(oldColor);
    }
}
