package game.model.entity;

public enum GameObjectType {
    ;

    private final String imageClassPath;
    private final GameObjectKind objectKind;

    private GameObjectType(final String imageClassPath, final GameObjectKind objectKind) {
        this.imageClassPath = imageClassPath;
        this.objectKind = objectKind;
    }

    public String getImageClassPath() {
        return this.imageClassPath;
    }

    public GameObjectKind getGameObjectKind() {
        return this.objectKind;
    }

}
