package game.view.window;

public interface WindowFactory {
    Window createWindow(GraphicalRenderer graphicalRenderer);

    enum GraphicalRenderer {
        SWING;
    }
}
