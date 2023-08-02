package game.controller.maploader;

import java.util.List;
import java.util.Optional;

import game.model.entity.GameWorld;

public interface MapWorldLoader {
    Optional<GameWorld> loadWorld(List<String> lines);
}
