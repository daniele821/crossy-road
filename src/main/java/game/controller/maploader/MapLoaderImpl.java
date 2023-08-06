package game.controller.maploader;

import java.util.HashMap;
import java.util.Map;

import game.model.entity.GameWorld;

public class MapLoaderImpl implements MapLoader {
    private final MapFileLoader mapFileLoader;
    private final MapWorldLoader mapWorldLoader;
    private final Map<String, GameWorld> maps = new HashMap<>();

    public MapLoaderImpl(final MapFileLoader mapFileLoader, final MapWorldLoader mapWorldLoader) {
        this.mapFileLoader = mapFileLoader;
        this.mapWorldLoader = mapWorldLoader;
    }

    public MapLoaderImpl() {
        this(new MapFileLoaderImpl(), new MapWorldLoaderImpl());
    }

    @Override
    public GameWorld loadWorld(final String mapPath) {
        if (!this.maps.containsKey(mapPath)) {
            final GameWorld world = this.mapWorldLoader.loadWorld(this.mapFileLoader.loadFile(mapPath));
            this.maps.put(mapPath, world);
        }
        return this.maps.get(mapPath).copy();
    }

}
