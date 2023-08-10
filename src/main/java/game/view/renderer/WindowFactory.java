package game.view.renderer;

public interface WindowFactory {
    Window createWindow(GraphicalRenderer graphicalRenderer);

    enum GraphicalRenderer {
        SWING;
    }
}
