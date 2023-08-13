package game.view.toolkit.swing.camera;

import java.awt.Graphics;

import game.model.entity.GameObject;
import game.model.entity.GameWorld;
import game.utility.Rectangle;

public interface Camera {
    void draw(Rectangle drawArea, Graphics drawer, GameWorld world, GameObject object);
}
