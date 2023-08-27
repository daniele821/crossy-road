package game.controller.api;

import java.util.Optional;

import game.model.api.resources.GameWorldLevel;
import game.view.api.GameDrawer;

public interface GameEngineFactory {
    static GameEngineFactory getDefaultFactory() {
        // TODO return an implementation when one exists!
        throw new UnsupportedOperationException("GameWorldFactory hasn't been implemented yet!");
    }

    GameEngine createEngine(final Optional<Integer> frameDuration, final GameDrawer drawer, final GameWorldLevel level);
}
