package game.controller.maploader.parser;

public interface MapParser<X> {
    void parseLine(String line);

    X getParsedObject();
}
