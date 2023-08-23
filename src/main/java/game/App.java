package game;

import static game.view.renderer.WindowFactory.GraphicalRenderer.SWING;

import game.view.renderer.WindowFactoryImpl;

public final class App {
    private App() {
    }

    public static void main(final String[] args) {
        new WindowFactoryImpl().createWindow(SWING).start();
    }
}
