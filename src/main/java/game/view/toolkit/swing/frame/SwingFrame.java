package game.view.toolkit.swing.frame;

import java.util.function.Consumer;

import javax.swing.JFrame;

import game.controller.engine.GameEngine;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldLevel;
import game.view.toolkit.swing.panel.SwingPanel;
import game.view.toolkit.swing.window.SwingWindow;

public interface SwingFrame {

    void start();

    void updateRenderer();

    void closeApplication();

    JFrame getJFrame();

    SwingPanel getSwingPanel();

    SwingWindow getSwingWindow();

    void setSwingPanel(SwingPanel panel);

    void setSwingWindow(SwingWindow swingWindow);

    void actOnGameEngine(Consumer<GameEngine> engineAction);

    void loadMap(GameWorldLevel level);

    GameWorld getCurrentWorld();
}
