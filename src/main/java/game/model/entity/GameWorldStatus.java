package game.model.entity;

import java.util.List;

import game.utility.Pair;
import game.utility.ProgressiveTime;

public interface GameWorldStatus {
    GameWorldStatus copy();

    int getCoins();

    void setCoins(int coins);

    List<Pair<ProgressiveTime, GameObjectType>> getPowerups();

    void setPowerups(List<Pair<ProgressiveTime, GameObjectType>> powerups);
}
