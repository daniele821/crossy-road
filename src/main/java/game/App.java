package game;

import game.view.window.WindowFactoryImpl;
import static game.view.window.WindowFactory.GraphicalRenderer;

public final class App {
    private App() {
    }

    public static void main(final String[] args) {
        new WindowFactoryImpl().createWindow(GraphicalRenderer.SWING);
    }
}
