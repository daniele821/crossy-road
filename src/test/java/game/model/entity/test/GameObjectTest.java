package game.model.entity.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import game.model.entity.impl.GameObjectImpl;
import game.utility.Rectangle;
import game.utility.Vector2D;

class GameObjectTest {
    @Test
    void testPosition() {
        final var rect1 = new Rectangle(.2, 12, 1, 0);
        final var rect2 = new Rectangle(4.67, 1.0, 0, -5);
        final var object = new GameObjectImpl(rect1, null, null);

        assertEquals(rect1, object.getPosition());
        assertDoesNotThrow(() -> object.setPosition(rect2));
        assertEquals(rect2, object.getPosition());
    }

    @Test
    void testSpeed() {
        final var speed1 = new Vector2D(1.2, -50);
        final var speed2 = new Vector2D(1.3, 0);
        final var object = new GameObjectImpl(null, speed1, null);

        assertEquals(speed1, object.getSpeed());
        assertDoesNotThrow(() -> object.setSpeed(speed2));
        assertEquals(speed2, object.getSpeed());
    }
}
