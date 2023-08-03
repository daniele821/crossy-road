package game.controller.maploader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import game.model.entity.GameObject;
import game.model.entity.GameObjectImpl;
import game.model.entity.GameObjectType;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldImpl;
import game.shared.Rectangle;
import game.shared.Vector2D;

public class MapWorldLoaderImpl implements MapWorldLoader {
    private static final String COMMENT = "#";
    private static final String VALUE_SEP = " ";
    private static final String ELEM_SEP = ",";
    private static final String ENTRY_SEP = "=";
    private static final String OBJECT_START = "[";
    private static final String OBJECT_END = "]";

    private List<String> removeCommentedAndEmptyLines(final List<String> lines) {
        return lines.stream()
                .map(String::strip)
                .filter(str -> !str.isEmpty())
                .filter(str -> !str.startsWith(COMMENT))
                .toList();
    }

    private Rectangle readRectangle(final String str) {
        final String[] values = str.strip().split(VALUE_SEP);
        return new Rectangle(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                Double.parseDouble(values[2]), Double.parseDouble(values[3]));
    }

    private Vector2D readVector2D(final String str) {
        final String[] values = str.strip().split(VALUE_SEP);
        return new Vector2D(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
    }

    private <X> List<X> readElements(final String str, final Function<String, X> reader) {
        final List<String> elems = Arrays.asList(str.strip().split(ELEM_SEP));
        return elems.stream().map(reader).toList();
    }

    private String removeTitle(final String line) {
        return line.strip().split(ENTRY_SEP)[1];
    }

    private Optional<GameWorld> initWorld(final List<String> lines) {
        if (lines.size() < 2) {
            return Optional.empty();
        }
        final var worldRect = readRectangle(removeTitle(lines.get(0)));
        final var cellDim = readVector2D(removeTitle(lines.get(1)));
        return Optional.of(new GameWorldImpl(List.of(), worldRect, cellDim));
    }

    private List<GameObject> getObject(final List<String> lines) {
        if (lines.size() < 3) {
            return List.of();
        }
        final String typeStr = lines.get(0).strip().replace(OBJECT_START, "").replace(OBJECT_END, "").strip();
        final GameObjectType type = GameObjectType.valueOf(typeStr);
        final Vector2D speed = readVector2D(removeTitle(lines.get(1)));
        final List<Vector2D> position = readElements(removeTitle(lines.get(2)), this::readVector2D);
        return position.stream().map(pos -> (GameObject) new GameObjectImpl(pos, speed, type)).toList();
    }

    private List<GameObject> getObjects(final List<String> allLines) {
        final List<GameObject> objects = new ArrayList<>();
        List<String> lines = allLines.stream().dropWhile(str -> !str.startsWith(OBJECT_START)).toList();
        while (lines.size() > 0) {
            objects.addAll(getObject(lines));
            lines = lines.stream().skip(1).dropWhile(str -> !str.startsWith(OBJECT_START)).toList();
        }
        return objects;
    }

    @Override
    public Optional<GameWorld> loadWorld(final List<String> lines) {
        final List<String> cleanedLines = removeCommentedAndEmptyLines(lines);
        final Optional<GameWorld> world = initWorld(cleanedLines);
        if (world.isEmpty()) {
            Optional.empty();
        }
        getObjects(cleanedLines).forEach(world.get()::addObject);
        return world;
    }

}
