package game.controller.maploader.parser;

import java.util.Optional;

import game.model.entity.GameWorldInfo;
import game.model.entity.GameWorldInfoImpl;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class MapInfoParser {
    private final MapParser mapParser = new MapParser();
    private Optional<Vector2D> cellSize = Optional.empty();
    private Optional<Rectangle> worldSize = Optional.empty();

    public void parseLine(final String line) {
        final var lineSplitted = this.mapParser.splitLine(line);
        switch (lineSplitted.getA()) {
            case "cell_size":
                this.cellSize = Optional.ofNullable(this.mapParser.parseVector2D(lineSplitted.getB()));
                break;
            case "world_rect":
                this.worldSize = Optional.ofNullable(this.mapParser.parseRectangle(lineSplitted.getB()));
                break;
            case "world_size":
                final Vector2D size = this.mapParser.parseVector2D(lineSplitted.getB());
                final Rectangle rect = new Rectangle(0, 0,
                        size.getX() * this.cellSize.get().getX(),
                        size.getY() * this.cellSize.get().getY());
                this.worldSize = Optional.ofNullable(rect);
                break;
            default:
                break;
        }
    }

    public GameWorldInfo getGameWorldInfo() {
        return new GameWorldInfoImpl(this.worldSize.get(), this.cellSize.get());
    }
}
