package game.controller.engine;

import java.util.Optional;

import game.controller.api.GameEngine;
import game.controller.api.GameEngineFactory;
import game.model.resources.GameWorldLevel;
import game.view.api.GameDrawer;

public class GameEngineFactoryImpl implements GameEngineFactory {

    @Override
    public GameEngine createEngine(Optional<Integer> frameDuration, GameDrawer drawer, GameWorldLevel level) {
        if (frameDuration.isPresent()) {
            return new GameEngineImpl(frameDuration.orElseThrow(), drawer, level);
        }
        return new GameEngineImpl(drawer, level);
    }

}
