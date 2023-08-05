package game.controller.maploader.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.entity.GameObjectType;
import game.utility.Vector2D;

public class MapObjectsParser {
    private final MapParser mapParser = new MapParser();
    private final GameObjectType type;
    private Optional<Vector2D> speed = Optional.empty();
    private List<Vector2D> position = new ArrayList<>();

    public MapObjectsParser(final GameObjectType type) {
        this.type = type;
    }

    public void parseLine(final String line) {
        final var lineSplitted = this.mapParser.splitLine(line);
        switch (lineSplitted.getA()) {
            case "speed":
                this.speed = Optional.ofNullable(this.mapParser.parseVector2D(lineSplitted.getB()));
                break;
            default:
                break;
        }
    }
}
