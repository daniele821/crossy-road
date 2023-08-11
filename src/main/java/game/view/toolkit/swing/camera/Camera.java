package game.view.toolkit.swing.camera;

import java.awt.Graphics;
import java.util.List;

import game.model.entity.GameWorld;

public interface Camera {
    void draw(Graphics drawer, GameWorld world, List<Integer> objectId);
}
