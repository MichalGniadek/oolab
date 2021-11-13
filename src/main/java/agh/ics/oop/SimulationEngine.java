package agh.ics.oop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimulationEngine implements IEngine {
    MoveDirection[] directions;
    IWorldMap map;
    List<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;

        animals = Arrays.stream(positions).map(pos -> new Animal(map, pos)).collect(Collectors.toList());
        animals.forEach(map::place);
    }

    @Override
    public void run() {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }
}
