package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    Vector2d size;
    List<Animal> animals;

    public RectangularMap(int width, int height) {
        size = new Vector2d(width, height);
        animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.precedes(size) &&
                !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        return animals.add(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.stream().filter(a -> a.isAt(position)).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0, 0), size);
    }
}
