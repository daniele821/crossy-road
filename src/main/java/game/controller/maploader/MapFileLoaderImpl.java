package game.controller.maploader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapFileLoaderImpl implements MapFileLoader {

    @Override
    public List<String> load(final String mapPath) {
        final var input = ClassLoader.getSystemResourceAsStream(mapPath);
        if (input == null) {
            return List.of();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            final List<String> lines = new ArrayList<>();
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            return lines;
        } catch (final IOException e) {
            throw new IllegalStateException("map " + mapPath + " failed loading", e);
        }
    }

}