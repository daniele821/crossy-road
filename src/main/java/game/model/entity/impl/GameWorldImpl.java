package game.model.entity.impl;

import java.util.ArrayList;
import java.util.List;

import game.model.entity.api.GameObject;
import game.model.entity.api.GameWorld;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects = new ArrayList<>();

    @Override
    public List<GameObject> getAllObjctes() {
        return List.copyOf(this.objects);
    }

    @Override
    public void removeObject(final int nth) {
        this.objects.remove(nth);
    }

    @Override
    public void addObject(final GameObject newObject) {
        this.objects.add(newObject);
    }

    @Override
    public String toString() {
        return "GameWorldImpl [objects=" + objects + "]";
    }

}
