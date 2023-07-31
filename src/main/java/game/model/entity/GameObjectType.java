package game.model.entity;

public enum GameObjectType {
    ;

    private final String imageClassPath;

    private GameObjectType(final String imageClassPath) {
        this.imageClassPath = imageClassPath;
    }

    public String getImageClassPath() {
        return this.imageClassPath;
    }

}
