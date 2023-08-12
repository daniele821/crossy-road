package game.view.toolkit.swing.camera.layout;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.utility.Rectangle;
import game.view.toolkit.swing.camera.Camera;
import game.view.toolkit.swing.camera.PlayerCamera;

public class OrizontalCameraLayout implements CameraLayout {
    private static final Camera CAMERA = new PlayerCamera(5);

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        final var quantity = objectId.size();
        final var heightTot = drawer.getClipBounds().getHeight();
        final var widthTot = drawer.getClipBounds().getWidth();
        final var height = heightTot / quantity;
        IntStream.range(0, quantity).forEach(i -> {
            CAMERA.draw(new Rectangle(0, i * height, widthTot, height), drawer, world, objectId.get(i));
        });
    }

}
