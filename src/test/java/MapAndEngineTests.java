import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapAndEngineTests {
    @Test
    void rectMapAndEngine0() {
        var directions = OptionsParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        var positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
        var map = new RectangularMap(10, 5);
        var engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | |^| | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | | | | | | | | | | |\r\n" +
                        "  2: | | | | | | | | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | |v| | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n",
                map.toString()
        );
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertFalse(map.isOccupied(new Vector2d(5, 0)));
        assertEquals("v", map.objectAt(new Vector2d(2, 0)).toString());
    }

    @Test
    void rectMapAndEngine1() {
        var directions = OptionsParser.parse(
                "b f r l f f f f f f f f f f l l f f f f f f".split(" ")
        );
        var map = new RectangularMap(10, 5);
        var positions = new Vector2d[]{new Vector2d(0, 0), new Vector2d(10, 5)};
        var engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(
                " y\\x  0 1 2 3 4 5 6 7 8 910\r\n" +
                        "  6: -----------------------\r\n" +
                        "  5: | | | | | | | | | | | |\r\n" +
                        "  4: | | | | | | | | | | | |\r\n" +
                        "  3: | | | | | |v| | | | | |\r\n" +
                        "  2: | | | | | |^| | | | | |\r\n" +
                        "  1: | | | | | | | | | | | |\r\n" +
                        "  0: | | | | | | | | | | | |\r\n" +
                        " -1: -----------------------\r\n",
                map.toString()
        );
        assertTrue(map.isOccupied(new Vector2d(5, 2)));
        assertTrue(map.isOccupied(new Vector2d(5, 3)));
        assertFalse(map.isOccupied(new Vector2d(5, 0)));
        assertEquals("^", map.objectAt(new Vector2d(5, 2)).toString());
    }

    @Test
    void grassMapAndEngine0() {
        var directions = OptionsParser.parse(
                "f b l r f f f f".split(" ")
        );
        var map = new GrassField(10);
        var positions = new Vector2d[]{new Vector2d(0, 0), new Vector2d(0, 1)};
        var engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(-2, 0)));
        assertEquals("<", map.objectAt(new Vector2d(-2, 0)).toString());
        assertTrue(map.isOccupied(new Vector2d(2, 1)));
        assertEquals(">", map.objectAt(new Vector2d(2, 1)).toString());
    }

    @Test
    void grassMapAndEngine1() {
        var directions = OptionsParser.parse(
                "r l f f f f f f f f".split(" ")
        );
        var map = new GrassField(10);
        var positions = new Vector2d[]{new Vector2d(10, 10), new Vector2d(0, 0)};
        var engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(14, 10)));
        assertEquals(">", map.objectAt(new Vector2d(14, 10)).toString());
        assertTrue(map.isOccupied(new Vector2d(-4, 0)));
        assertEquals("<", map.objectAt(new Vector2d(-4, 0)).toString());
    }

    @Test
    void exceptions(){
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> OptionsParser.parse("r l f x f r".split(" "))
        );
        assertEquals("x is not a legal move.", exception.getMessage());

        var exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> OptionsParser.parse("r l f lala f r".split(" "))
        );
        assertEquals("lala is not a legal move.", exception2.getMessage());

        var exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    var map = new GrassField(10);
                    map.place(new Animal(map, new Vector2d(2, 2)));
                    map.place(new Animal(map, new Vector2d(2, 2)));
                }
        );
        assertEquals("Position (2,2) is already occupied.", exception3.getMessage());

        var exception4 = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    var map = new RectangularMap(10, 20);
                    map.place(new Animal(map, new Vector2d(3, 4)));
                    map.place(new Animal(map, new Vector2d(3, 4)));
                }
        );
        assertEquals("Position (3,4) is already occupied.", exception4.getMessage());
    }
}
