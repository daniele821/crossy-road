package game.view.toolkit.swing.frame;

import java.awt.Toolkit;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.JFrame;

import game.controller.engine.GameEngine;
import game.controller.engine.GameEngineImpl;
import game.controller.maploader.MapLoader;
import game.controller.maploader.MapLoaderImpl;
import game.model.entity.GameWorld;
import game.model.entity.GameWorldLevel;
import game.view.toolkit.swing.panel.SwingPanel;
import game.view.toolkit.swing.window.SwingWindow;

public class SwingFrameImpl implements SwingFrame {
    private static final GameEngine ENGINE = new GameEngineImpl();
    private static final MapLoader MAP_LOADER = new MapLoaderImpl();
    private final Optional<JFrame> frame = Optional.ofNullable(new JFrame());
    private Optional<GameWorld> currentWorld = Optional.empty();
    private Optional<SwingPanel> panel = Optional.empty();
    private Optional<SwingWindow> window = Optional.empty();

    @Override
    public void start() {
        getJFrame().setTitle("Crossy-Road");
        getJFrame().setLocationByPlatform(true);
        getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getJFrame().setSize(Toolkit.getDefaultToolkit().getScreenSize());
        getJFrame().setExtendedState(getJFrame().getExtendedState() | JFrame.MAXIMIZED_BOTH);
        getJFrame().setVisible(true);
    }

    @Override
    public void updateRenderer() {
        getJFrame().validate();
        getJFrame().repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void closeApplication() {
        getSwingPanel().destroy();
        getJFrame().dispose();
    }

    @Override
    public JFrame getJFrame() {
        return this.frame.get();
    }

    @Override
    public SwingPanel getSwingPanel() {
        return this.panel.get();
    }

    @Override
    public void setSwingPanel(final SwingPanel panel) {
        this.panel.map(SwingPanel::getJPanel).ifPresent(getJFrame()::remove);
        this.panel.ifPresent(panelTmp -> panelTmp.destroy());
        this.panel = Optional.ofNullable(panel);
        this.panel.ifPresent(panelTmp -> panelTmp.setSwingFrame(this));
        this.panel.map(SwingPanel::getJPanel).ifPresent(getJFrame()::add);
        this.panel.ifPresent(SwingPanel::start);
        updateRenderer();
    }

    @Override
    public SwingWindow getSwingWindow() {
        return this.window.get();
    }

    @Override
    public void setSwingWindow(final SwingWindow swingWindow) {
        this.window = Optional.ofNullable(swingWindow);
    }

    @Override
    public GameWorld getCurrentWorld() {
        return this.currentWorld.get();
    }

    @Override
    public void actOnGameEngine(final Consumer<GameEngine> engineAction) {
        engineAction.accept(ENGINE);
    }

    @Override
    public void loadMap(final GameWorldLevel level) {
        this.currentWorld = Optional.ofNullable(MAP_LOADER.loadWorld(level.getPath()));
    }
}
