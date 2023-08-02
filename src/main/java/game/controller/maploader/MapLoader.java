package game.controller.maploader;

import java.util.Optional;

import game.model.entity.GameWorld;

public interface MapLoader {
    Optional<GameWorld> loadWorld(String mapPath);
}
