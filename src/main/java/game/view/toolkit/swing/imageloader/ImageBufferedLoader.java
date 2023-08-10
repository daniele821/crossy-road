package game.view.toolkit.swing.imageloader;

import java.awt.Image;

public interface ImageBufferedLoader extends ImageLoader {
    Image loadImage(String classPath, int x, int y);
}
