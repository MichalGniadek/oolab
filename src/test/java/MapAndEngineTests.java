import agh.ics.oop.OptionsParser;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapAndEngineTests {
    @Test
    void mapAndEngine0() {
        var directions = OptionsParser.parse("f b r l f f r r f f f f f f f f".split(" "));
        var map = new RectangularMap(10, 5);
        var positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
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
    }

    @Test
    void mapAndEngine1() {
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
    }
}
