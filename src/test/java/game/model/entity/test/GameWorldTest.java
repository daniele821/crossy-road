package game.model.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.model.entity.impl.GameObjectImpl;
import game.model.entity.impl.GameWorldImpl;
import game.utility.Vector2D;

public class GameWorldTest {

    @Test
    void addAndRemovalTest() {
        final var obj1 = new GameObjectImpl(null, new Vector2D(1, 1), null);
        final var obj2 = new GameObjectImpl(null, new Vector2D(2, 2), null);
        final var world = new GameWorldImpl();

        assertEquals(List.of(), world.getAllObjctes());
        world.addObject(obj1);
        world.addObject(obj2);
        world.addObject(obj1);
        assertEquals(List.of(obj1, obj2, obj1), world.getAllObjctes());
        world.removeObject(obj1);
        assertEquals(List.of(obj2), world.getAllObjctes());
        world.removeObject(obj2);
        assertEquals(List.of(), world.getAllObjctes());
    }

    @Test
    void nullAddAndRemovalTest() {
        final var world = new GameWorldImpl();

        assertEquals(List.of(), world.getAllObjctes());
        world.addObject(null);
        assertEquals(List.of(), world.getAllObjctes());
        world.removeObject(null);
        assertEquals(List.of(), world.getAllObjctes());
    }

}
