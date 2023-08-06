package game.controller.maploader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import game.controller.maploader.parser.MapInfoParser;
import game.controller.maploader.parser.MapObjectsParser;
import game.model.entity.GameObject;
import game.model.entity.GameObjectType;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldImpl;
import game.model.entity.GameWorldInfo;

public class MapWorldLoaderImpl implements MapWorldLoader {
    private static final String COMMENT = "#";
    private static final String OBJECT_LINE = ">";
    private final List<GameObject> objects = new ArrayList<>();
    private GameWorldInfo gameWorldInfo;

    @Override
    public GameWorld loadWorld(final List<String> lines) {
        final List<String> clearedLines = clearLines(lines);

        // GameWorldInfo
        final var mapInfoParser = new MapInfoParser();
        getUntilNextObject(clearedLines).forEach(mapInfoParser::parseLine);
        this.gameWorldInfo = mapInfoParser.getGameWorldInfo();

        // GameObjects
        List<String> linesLeft = getFromNextObject(clearedLines);
        while (!linesLeft.isEmpty()) {
            loadObjects(linesLeft);
            linesLeft = getFromNextObject(linesLeft);
        }

        // GameWorld
        return new GameWorldImpl(this.objects, this.gameWorldInfo);
    }

    private void loadObjects(final List<String> linesLeft) {
        final GameObjectType type = GameObjectType.valueOf(linesLeft.get(0).replace(OBJECT_LINE, "").strip());
        final var mapObjectsParser = new MapObjectsParser(type, this.gameWorldInfo);
        getUntilNextObject(linesLeft).forEach(mapObjectsParser::parseLine);
        this.objects.addAll(mapObjectsParser.getObjects());
    }

    private List<String> clearLines(final List<String> lines) {
        return lines.stream()
                .filter(Predicate.not(String::isEmpty))
                .filter(str -> !str.startsWith(COMMENT))
                .toList();
    }

    private List<String> getUntilNextObject(final List<String> lines) {
        return lines.stream()
                .skip(!lines.isEmpty() && lines.get(0).startsWith(OBJECT_LINE) ? 1 : 0)
                .takeWhile(str -> !str.startsWith(OBJECT_LINE))
                .toList();
    }

    private List<String> getFromNextObject(final List<String> lines) {
        return lines.stream()
                .skip(!lines.isEmpty() && lines.get(0).startsWith(OBJECT_LINE) ? 1 : 0)
                .dropWhile(str -> !str.startsWith(OBJECT_LINE))
                .toList();
    }
}
