package game.controller.maploader.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.entity.GameObject;
import game.model.entity.GameObjectImpl;
import game.model.entity.GameObjectType;
import game.utility.Rectangle;
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
            case "position":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.add(this.mapParser.parseVector2D(pos));
                }
                break;
            case "pos_cell":
                // TODO
                break;
            case "pos_rect":
                // TODO
                break;
            case "pos_line":
                // TODO
                break;
            default:
                break;
        }
    }

    public List<GameObject> getObjects() {
        return this.position.stream()
                .map(vect -> new Rectangle(vect.getX(), vect.getY(), type.getLenX(), type.getLenY()))
                .map(rect -> (GameObject) new GameObjectImpl(rect, this.speed.get(), type, true))
                .toList();
    }
}
