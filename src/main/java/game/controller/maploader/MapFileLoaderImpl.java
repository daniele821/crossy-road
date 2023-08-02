package game.controller.maploader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFileLoaderImpl implements MapFileLoader {
    private final Map<String, List<String>> maps = new HashMap<>();

    @Override
    public List<String> load(final String mapPath) {
        if (!this.maps.containsKey(mapPath)) {
            final var input = ClassLoader.getSystemResourceAsStream(mapPath);
            if (input == null) {
                return List.of();
            }
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                final List<String> lines = new ArrayList<>();
                while (reader.ready()) {
                    lines.add(reader.readLine());
                }
                this.maps.put(mapPath, lines);
            } catch (final IOException e) {
                throw new IllegalStateException("map " + mapPath + " failed loading", e);
            }
        }
        return this.maps.get(mapPath);
    }

}
