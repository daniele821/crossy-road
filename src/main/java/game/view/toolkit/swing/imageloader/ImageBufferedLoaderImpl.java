package game.view.toolkit.swing.imageloader;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageBufferedLoaderImpl extends ImageLoaderImpl implements ImageBufferedLoader {
    private final Map<ImageInfo, Image> images = new HashMap<>();

    @Override
    public Image loadImage(final String classPath, final int x, final int y) {
        final var imageInfo = new ImageInfo(classPath, x, y);
        final var image = loadImage(classPath);

        if (!this.images.containsKey(imageInfo)) {
            this.images.put(imageInfo, image.getScaledInstance(x, y, Image.SCALE_SMOOTH));
        }

        return this.images.get(imageInfo);
    }

    private final class ImageInfo {
        private final String imagePath;
        private final int x;
        private final int y;

        private ImageInfo(final String imagePath, final int x, final int y) {
            this.imagePath = imagePath;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ImageInfo other = (ImageInfo) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
                return false;
            }
            if (imagePath == null) {
                if (other.imagePath != null) {
                    return false;
                }
            } else if (!imagePath.equals(other.imagePath)) {
                return false;
            }
            if (x != other.x) {
                return false;
            }
            return y == other.y;
        }

        private ImageBufferedLoaderImpl getEnclosingInstance() {
            return ImageBufferedLoaderImpl.this;
        }

        @Override
        public String toString() {
            return "ImageInfo [ImagePath=" + imagePath + ", x=" + x + ", y=" + y + "]";
        }

    }

    @Override
    public String toString() {
        return "ImageBufferedLoaderImpl [images=" + images + "]";
    }

}
