package game.view.toolkit.swing.camera.layout;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.utility.Rectangle;
import game.view.toolkit.swing.camera.Camera;
import game.view.toolkit.swing.camera.PlayerCamera;

public class VerticalCameraLayout implements CameraLayout {
    private static final Camera CAMERA = new PlayerCamera(8);

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        final var quantity = objectId.size();
        final var widthTot = drawer.getClipBounds().getWidth();
        final var width = widthTot / quantity;
        IntStream.range(0, quantity).forEach(i -> {
            CAMERA.draw(new Rectangle(i * width, 0, (i + 1) * width, 0), drawer, world, i);
        });
    }
}
