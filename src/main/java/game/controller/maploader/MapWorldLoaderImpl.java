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
    private MapInfoParser mapInfoParser = new MapInfoParser();
    private MapObjectsParser mapObjectsParser;
    private GameWorldInfo gameWorldInfo;
    private List<GameObject> objects = new ArrayList<>();

    @Override
    public GameWorld loadWorld(final List<String> lines) {
        final List<String> clearedLines = lines.stream()
                .filter(Predicate.not(String::isEmpty))
                .filter(str -> !str.startsWith(COMMENT))
                .toList();

        final List<String> infoLines = clearedLines.stream()
                .takeWhile(str -> !str.startsWith(OBJECT_LINE))
                .toList();

        infoLines.stream().forEach(str -> mapInfoParser.parseLine(str));
        this.gameWorldInfo = this.mapInfoParser.getGameWorldInfo();

        List<String> linesLeft = clearedLines.stream()
                .dropWhile(str -> !str.startsWith(OBJECT_LINE))
                .toList();

        while (!linesLeft.isEmpty()) {
            loadObjects(linesLeft);
            linesLeft = linesLeft.stream()
                    .skip(1)
                    .dropWhile(str -> !str.startsWith(OBJECT_LINE))
                    .toList();
        }

        return new GameWorldImpl(this.objects, this.gameWorldInfo);
    }

    private void loadObjects(final List<String> linesLeft) {
        final GameObjectType type = GameObjectType.valueOf(linesLeft.get(0).replace(OBJECT_LINE, "").strip());
        this.mapObjectsParser = new MapObjectsParser(type, this.gameWorldInfo);

        final List<String> objectLines = linesLeft.stream()
                .skip(1)
                .takeWhile(str -> !str.startsWith(OBJECT_LINE))
                .toList();

        this.mapObjectsParser = new MapObjectsParser(type, this.gameWorldInfo);
        objectLines.forEach(str -> mapObjectsParser.parseLine(str));

        this.objects.addAll(this.mapObjectsParser.getObjects());
    }

    // TODO: refactor this class to make it more mantainable!
}
