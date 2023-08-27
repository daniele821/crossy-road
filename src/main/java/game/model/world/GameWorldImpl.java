package game.model.world;

import java.util.List;

import game.common.Pair;
import game.common.Rectangle;
import game.model.api.GameWorld;

public class GameWorldImpl implements GameWorld {
    private GameWorldStatus worldStatus;

    public GameWorldImpl(final GameWorldStatus worldStatus) {
        this.worldStatus = worldStatus;
    }

    @Override
    public Rectangle getWorldBounds() {
        return worldStatus.getWorldBounds();
    }

    @Override
    public Rectangle getPositionToCenter() {
        return worldStatus.getPlayer().getPosition();
    }

    @Override
    public List<Pair<Rectangle, String>> getObjectsToDraw() {
        return worldStatus.getObjectsPath();
    }

    @Override
    public void moveAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveAll'");
    }

}
