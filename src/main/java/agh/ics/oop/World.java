package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        var directions = OptionsParser.parse(args);
        var map = new GrassField(10);
        var positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
        var engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
    }
}

// Notatki:
// IMapElement i AbstractWorldMapElement są w tym wypadku niepotrzebne bo Grass i Animal
// są wystarczjąco od siebie różne i tylko skomplikowało by je implementację GrassField.