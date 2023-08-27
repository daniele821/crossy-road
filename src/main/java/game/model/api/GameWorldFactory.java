package game.model.api;

import game.model.api.resources.GameWorldLevel;

public interface GameWorldFactory {
    static GameWorldFactory getDefaultFactory() {
        // TODO return an implementation when one exists!
        throw new UnsupportedOperationException("GameWorldFactory hasn't been implemented yet!");
    }

    GameWorld loadLevel(GameWorldLevel level);
}
