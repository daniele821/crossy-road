package game.controller.maploader.parser;

import java.util.Arrays;
import java.util.List;

import game.utility.Pair;
import game.utility.Rectangle;
import game.utility.Vector2D;

public class MapParserUtils {
    private static final String EMPTY = "";
    private static final String LINE_SPLITTER = "=";
    private static final String ELEM_SPLITTER = ",";
    private static final String OBJECT_SPLITTER = " ";

    public List<String> split(final String str, final String splitter) {
        return Arrays.asList(str.split(splitter)).stream().map(String::strip).toList();
    }

    public Pair<String, String> splitLine(final String str) {
        final var splitted = split(str, LINE_SPLITTER);
        return new Pair<>(splitted.get(0).strip(), splitted.size() <= 1 ? EMPTY : splitted.get(1).strip());
    }

    public List<String> splitElem(final String str) {
        return split(str, ELEM_SPLITTER).stream().map(String::strip).toList();
    }

    public Vector2D parseVector2D(final String str) {
        final var splitted = split(str, OBJECT_SPLITTER);
        final var x = Double.parseDouble(splitted.get(0));
        final var y = Double.parseDouble(splitted.get(1));
        return new Vector2D(x, y);
    }

    public Rectangle parseRectangle(final String str) {
        final var splitted = split(str, OBJECT_SPLITTER);
        final var x = Double.parseDouble(splitted.get(0));
        final var y = Double.parseDouble(splitted.get(1));
        final var lenX = Double.parseDouble(splitted.get(2));
        final var lenY = Double.parseDouble(splitted.get(3));
        return new Rectangle(x, y, lenX, lenY);
    }
}
