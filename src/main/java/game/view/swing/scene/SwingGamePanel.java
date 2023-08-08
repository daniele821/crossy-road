package game.view.swing.scene;

import java.awt.Graphics;
import java.util.Optional;

import javax.swing.JPanel;

import game.model.entity.GameWorld;

public class SwingGamePanel extends JPanel implements SwingPanel {
    private static final long serialVersionUID = 2115458124524211780L;
    private transient Optional<GameWorld> gameWorld = Optional.empty();

    @Override
    public JPanel getPanel() {
        return this;
    }

    public Optional<GameWorld> getGameWorld() {
        return this.gameWorld.map(GameWorld::copy);
    }

    public void setGameWorld(final GameWorld gameWorld) {
        this.gameWorld = Optional.ofNullable(gameWorld).map(GameWorld::copy);
    }

    @Override
    protected void paintComponent(final Graphics drawer) {
        super.paintComponent(drawer);

        // TODO: implement with a concept of camera
    }

}
