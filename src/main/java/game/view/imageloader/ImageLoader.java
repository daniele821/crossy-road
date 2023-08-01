package game.view.imageloader;

import java.awt.Image;
import java.util.Optional;

public interface ImageLoader {
    Optional<Image> load(String classPath);
}
