package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.utility.Rectangle;

public class VerticalCameraLayout implements CameraLayout {
    private static final Camera CAMERA = new ScalerCamera();

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        final var quantity = objectId.size();
        final var heightTot = drawer.getClipBounds().getHeight();
        final var widthTot = drawer.getClipBounds().getWidth();
        final var width = widthTot / quantity;
        IntStream.range(0, quantity).forEach(i -> {
            CAMERA.draw(new Rectangle(i * width, 0, width, heightTot), drawer, world, objectId.get(i));
        });
    }
}
