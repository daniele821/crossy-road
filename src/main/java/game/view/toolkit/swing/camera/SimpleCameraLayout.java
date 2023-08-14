package game.view.toolkit.swing.camera;

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

        final List<GameObject> presentObject = objectId.stream()
                .map(id -> WORLD_UTIL.getPresentObject(id, world))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        if (presentObject.isEmpty()) {
            return;
        }
        final double widthTot = drawer.getClipBounds().getWidth();
        final double heightTot = drawer.getClipBounds().getHeight();
        final double width = widthTot / presentObject.size();
        final double height = heightTot / presentObject.size();
        IntStream.range(0, presentObject.size()).forEach(i -> {
            final var orizRect = new Rectangle(0, height * i, widthTot, height);
            final var vertRect = new Rectangle(width * i, 0, width, heightTot);
            final var rectangle = switch (this.type) {
                case VERTICAL -> vertRect;
                case ORIZONTAL -> orizRect;
                case BEST_FIT -> width > height ? vertRect : orizRect;
                default -> vertRect;
            };
            CAMERA.draw(rectangle, drawer, world, presentObject.get(i));
        });
    }
}
