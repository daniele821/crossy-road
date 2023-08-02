package game.controller.maploader;

import java.util.List;

public interface MapLoader {
    List<String> load(String mapPath);
}
