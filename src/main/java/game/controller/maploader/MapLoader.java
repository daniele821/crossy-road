package game.controller.maploader;

import game.model.entity.GameWorld;

public interface MapLoader {
    GameWorld loadWorld(String mapPath);
}
