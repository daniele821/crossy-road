package game.model.logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.model.entity.GameObject;
import game.shared.Pair;
import game.shared.Vector2D;

public class InputHandler {
    private final List<Pair<GameObject, Vector2D>> actions = new ArrayList<>();
    private final Set<GameObject> objects = new HashSet<>();

    public void storeAction(final GameObject gameObject, final Vector2D action) {
        if (this.objects.contains(gameObject)) {
            return;
        }
        this.objects.add(gameObject);
        this.actions.add(new Pair<>(gameObject, action));
    }

    public List<Pair<GameObject, Vector2D>> getStoredAction() {
        final var buffer = List.copyOf(this.actions);
        this.actions.clear();
        this.objects.clear();
        return buffer;
    }
}
