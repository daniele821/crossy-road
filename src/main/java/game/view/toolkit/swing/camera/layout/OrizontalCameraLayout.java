package game.view.toolkit.swing.camera.layout;

import java.awt.Graphics;
import java.util.List;
import java.util.stream.IntStream;

import game.model.entity.GameWorld;
import game.utility.Rectangle;
import game.view.toolkit.swing.camera.Camera;
import game.view.toolkit.swing.camera.PlayerCamera;

public class OrizontalCameraLayout implements CameraLayout {
    private static final Camera CAMERA = new PlayerCamera(8);

    @Override
    public void draw(final Graphics drawer, final GameWorld world, final List<Integer> objectId) {
        final var height = drawer.getClipBounds().getHeight() / objectId.size();
        IntStream.range(0, objectId.size()).forEach(i -> {
            CAMERA.draw(new Rectangle(0, i * height, 0, (i + 1) * height), drawer, world, objectId.get(i));
        });
    }

}
