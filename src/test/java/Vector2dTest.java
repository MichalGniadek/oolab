import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void testEquals() {
        assertTrue(new Vector2d(1, 1).equals(new Vector2d(1, 1)));
        assertFalse(new Vector2d(2, 1).equals(new Vector2d(1, 1)));
        assertFalse(new Vector2d(1, 1).equals(new Vector2d(1, 2)));
    }

    @Test
    void testToString() {
        assertEquals(new Vector2d(1, -1).toString(), "(1,-1)");
        assertEquals(new Vector2d(123, 0).toString(), "(123,0)");
    }

    @Test
    void precedes() {
        assertTrue(new Vector2d(2, 3).precedes(new Vector2d(5, 3)));
        assertFalse(new Vector2d(7, 2).precedes(new Vector2d(5, 3)));
        assertFalse(new Vector2d(2, 7).precedes(new Vector2d(5, 3)));
        assertFalse(new Vector2d(7, 7).precedes(new Vector2d(5, 3)));
    }

    @Test
    void follows() {
        assertTrue(new Vector2d(5, 3).follows(new Vector2d(2, 3)));
        assertFalse(new Vector2d(5, 3).follows(new Vector2d(7, 2)));
        assertFalse(new Vector2d(5, 3).follows(new Vector2d(2, 7)));
        assertFalse(new Vector2d(5, 3).follows(new Vector2d(7, 7)));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(3, 0)),
                new Vector2d(3, 2));
        assertEquals(new Vector2d(3, 0).upperRight(new Vector2d(1, 2)),
                new Vector2d(3, 2));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(3, 0)),
                new Vector2d(1, 0));
        assertEquals(new Vector2d(3, 0).lowerLeft(new Vector2d(1, 2)),
                new Vector2d(1, 0));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(1, 2).add(new Vector2d(-1, -1)),
                new Vector2d(0, 1));
    }

    @Test
    void substract() {
        assertEquals(new Vector2d(1, 2).substract(new Vector2d(-1, -1)),
                new Vector2d(2, 3));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(12, 31).opposite(), new Vector2d(-12, -31));
    }
}
