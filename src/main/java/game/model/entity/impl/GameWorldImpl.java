package game.model.entity.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import game.model.entity.api.GameObject;
import game.model.entity.api.GameWorld;

public class GameWorldImpl implements GameWorld {
    private final List<GameObject> objects = new ArrayList<>();

    @Override
    public List<GameObject> getAllObjctes() {
        return List.copyOf(this.objects);
    }

    @Override
    public void removeObject(final GameObject objectToRemove) {
        while (this.objects.contains(objectToRemove)) {
            this.objects.remove(objectToRemove);
        }
    }

    @Override
    public void addObject(final GameObject newObject) {
        Optional.ofNullable(newObject).ifPresent(this.objects::add);
    }

    @Override
    public String toString() {
        return "GameWorldImpl [objects=" + objects + "]";
    }

}
