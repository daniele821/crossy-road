package game.controller.maploader.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import game.model.entity.GameObject;
import game.model.entity.GameObjectImpl;
import game.model.entity.GameObjectType;
import game.model.entity.GameWorldInfo;
import game.model.entity.GameWorldUtil;
import game.model.entity.GameWorldUtilImpl;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class MapObjectsParser implements MapParser<List<GameObject>> {
    private final GameWorldUtil worldUtil = new GameWorldUtilImpl();
    private final MapParserUtils mapParser = new MapParserUtils();
    private final GameObjectType type;
    private final GameWorldInfo gameWorldInfo;
    private final List<Vector2D> position = new ArrayList<>();
    private Optional<Vector2D> wraparound = Optional.empty();
    private Vector2D speed = new Vector2D(0, 0);
    private boolean isPresent = true;

    public MapObjectsParser(final GameObjectType type, final GameWorldInfo gameWorldInfo) {
        this.type = type;
        this.gameWorldInfo = gameWorldInfo.copy();
    }

    @Override
    public void parseLine(final String line) {
        final var lineSplitted = this.mapParser.splitLine(line);
        switch (lineSplitted.getA()) {
            case "presence":
                this.isPresent = Boolean.parseBoolean(lineSplitted.getB());
                break;
            case "speed":
                this.speed = this.mapParser.parseVector2D(lineSplitted.getB());
                break;
            case "wraparound":
                this.wraparound = Optional.ofNullable(this.mapParser.parseVector2D(lineSplitted.getB()));
                break;
            case "position":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.add(this.mapParser.parseVector2D(pos));
                }
                break;
            case "pos_cell":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.add(convertCellToPos(this.mapParser.parseVector2D(pos)));
                }
                break;
            case "pos_rect":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.addAll(convertRectToCellsToPos(this.mapParser.parseRectangle(pos)));
                }
                break;
            case "pos_line":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.addAll(convertDoubleToCellsToPos(Double.parseDouble(pos)));
                }
                break;
            case "pos_lines":
                for (final var pos : this.mapParser.splitElem(lineSplitted.getB())) {
                    this.position.addAll(convertDoublesToCellsToPos(this.mapParser.parseVector2D(pos)));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public List<GameObject> getParsedObject() {
        return this.position.stream()
                .map(vect -> new Rectangle(vect.getX(), vect.getY(), type.getLenX(), type.getLenY()))
                .map(rect -> (GameObject) new GameObjectImpl(rect, speed, type, isPresent, wraparound))
                .toList();
    }

    private Vector2D convertCellToPos(final Vector2D cell) {
        return this.worldUtil.convertCellToPixel(cell, this.gameWorldInfo, this.type);
    }

    private List<Vector2D> convertRectToCellsToPos(final Rectangle rect) {
        final List<Vector2D> res = new ArrayList<>();
        final double x1 = rect.getX();
        final double y1 = rect.getY();
        final double x2 = rect.getLenX();
        final double y2 = rect.getLenY();
        for (double x = Double.min(x1, x2); x <= Double.max(x1, x2); x++) {
            for (double y = Double.min(y1, y2); y <= Double.max(y1, y2); y++) {
                res.add(convertCellToPos(new Vector2D(x, y)));
            }
        }
        return res;
    }

    private List<Vector2D> convertDoubleToCellsToPos(final double line) {
        final double cellX = gameWorldInfo.getCellSize().getX();
        final int lenghtLine = (int) (gameWorldInfo.getWorldBounds().getLenX() / cellX);
        final boolean fixLen = lenghtLine * cellX < gameWorldInfo.getWorldBounds().getLenX();
        final int fixedLen = (fixLen ? 1 : 0) + lenghtLine;
        return IntStream.range(0, fixedLen).mapToObj(i -> convertCellToPos(new Vector2D(i, line))).toList();
    }

    private List<Vector2D> convertDoublesToCellsToPos(final Vector2D lines) {
        final List<Vector2D> res = new ArrayList<>();
        IntStream.rangeClosed((int) lines.getX(), (int) lines.getY())
                .forEach(i -> res.addAll(convertDoubleToCellsToPos(i)));
        return res;
    }
}
