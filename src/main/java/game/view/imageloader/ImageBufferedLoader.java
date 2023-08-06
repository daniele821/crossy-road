package game.view.imageloader;

import java.awt.Image;

public interface ImageBufferedLoader {
    Image loadImage(String classPath, int x, int y);
}
