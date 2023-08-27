package game.view.api;

public interface GameDrawerFactory {
    static GameDrawerFactory getDefaultFactory() {
        // TODO return an implementation when one exists!
        throw new UnsupportedOperationException("GameWorldFactory hasn't been implemented yet!");
    }

    GameDrawer createDrawer(Renderer renderer);

    enum Renderer {
        SWING;
    }
}
