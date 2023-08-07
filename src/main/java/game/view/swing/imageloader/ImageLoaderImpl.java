package game.view.swing.imageloader;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageLoaderImpl implements ImageLoader {
    private final Map<String, Image> images = new HashMap<>();

    @Override
    public Image loadImage(final String classPath) {
        if (!images.containsKey(classPath)) {
            try {
                this.images.put(classPath, ImageIO.read(ClassLoader.getSystemResourceAsStream(classPath)));
            } catch (final IOException e) {
                throw new IllegalStateException("image" + classPath + "failed loading!", e);
            }
        }
        return this.images.get(classPath);
    }

    @Override
    public String toString() {
        return "ImageLoaderImpl [images=" + images + "]";
    }

}
