package game.view.imageloader;

import java.awt.Image;

public interface ImageBufferedLoader extends ImageLoader {
    Image loadImage(String classPath, int x, int y);
}
