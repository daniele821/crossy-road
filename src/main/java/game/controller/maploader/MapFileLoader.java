package game.controller.maploader;

import java.util.List;

public interface MapFileLoader {
    List<String> loadFile(String mapPath);
}
