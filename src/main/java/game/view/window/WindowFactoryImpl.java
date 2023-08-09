package game.view.window;

import game.view.swing.window.SwingWindow;

public class WindowFactoryImpl implements WindowFactory {

    @Override
    public Window createWindow(final GraphicalRenderer graphicalRenderer) {
        return switch (graphicalRenderer) {
            case SWING -> new SwingWindow();
        };
    }

}
