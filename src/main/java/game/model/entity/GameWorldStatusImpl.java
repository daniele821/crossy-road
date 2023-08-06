package game.model.entity;

import java.util.List;

import game.utility.Pair;
import game.utility.ProgressiveTime;

public class GameWorldStatusImpl implements GameWorldStatus {
    private List<Pair<ProgressiveTime, GameObjectType>> powerups;
    private int coins;

    public GameWorldStatusImpl(final int coins, final List<Pair<ProgressiveTime, GameObjectType>> powerups) {
        this.coins = coins;
        this.powerups = powerups.stream().map(Pair::copy).toList();
    }

    @Override
    public GameWorldStatus copy() {
        return new GameWorldStatusImpl(this.coins, this.powerups);
    }

    @Override
    public int getCoins() {
        return this.coins;
    }

    @Override
    public void setCoins(final int coins) {
        this.coins = coins;
    }

    @Override
    public List<Pair<ProgressiveTime, GameObjectType>> getPowerups() {
        return this.powerups.stream().map(Pair::copy).toList();
    }

    @Override
    public void setPowerups(final List<Pair<ProgressiveTime, GameObjectType>> powerups) {
        this.powerups = powerups.stream().map(Pair::copy).toList();
    }

}
