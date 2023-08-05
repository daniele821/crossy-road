package game.controller.maploader;

import java.util.List;

import game.model.entity.GameWorld;

public interface MapWorldLoader {
    GameWorld loadWorld(List<String> lines);
}
