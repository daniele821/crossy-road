package game.controller.api;

public interface GameEngineFactory {
    static GameEngineFactory getDefaultFactory() {
        // TODO return an implementation when one exists!
        throw new UnsupportedOperationException("GameWorldFactory hasn't been implemented yet!");
    }

    GameEngine createEngine();
}
