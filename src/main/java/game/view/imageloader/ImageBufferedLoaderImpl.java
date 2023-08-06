package game.view.imageloader;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageBufferedLoaderImpl implements ImageBufferedLoader {
    private final ImageLoader imageLoader;
    private final Map<ImageInfo, Image> images;

    public ImageBufferedLoaderImpl(final ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        this.images = new HashMap<>();
    }

    public ImageBufferedLoaderImpl() {
        this(new ImageLoaderImpl());
    }

    @Override
    public Image loadImage(final String classPath, final int x, final int y) {
        final var imageInfo = new ImageInfo(classPath, x, y);
        final var image = this.imageLoader.loadImage(classPath);

        if (!this.images.containsKey(imageInfo)) {
            this.images.put(imageInfo, image.getScaledInstance(x, y, Image.SCALE_SMOOTH));
        }

        return this.images.get(imageInfo);
    }

    private class ImageInfo {
        private final String ImagePath;
        private final int x;
        private final int y;

        private ImageInfo(final String imagePath, final int x, final int y) {
            this.ImagePath = imagePath;
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((ImagePath == null) ? 0 : ImagePath.hashCode());
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
            ImageInfo other = (ImageInfo) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance())) {
                return false;
            }
            if (ImagePath == null) {
                if (other.ImagePath != null) {
                    return false;
                }
            } else if (!ImagePath.equals(other.ImagePath)) {
                return false;
            }
            if (x != other.x) {
                return false;
            }
            if (y != other.y) {
                return false;
            }
            return true;
        }

        private ImageBufferedLoaderImpl getEnclosingInstance() {
            return ImageBufferedLoaderImpl.this;
        }

        @Override
        public String toString() {
            return "ImageInfo [ImagePath=" + ImagePath + ", x=" + x + ", y=" + y + "]";
        }

    }
}
