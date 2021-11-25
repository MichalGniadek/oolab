package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    protected abstract Vector2d downLeftCorner();
    protected abstract Vector2d upRightCorner();

    @Override
    public boolean place(Animal animal) {
        return animals.add(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public Object animalAt(Vector2d position) {
        return animals.stream().filter(a -> a.isAt(position)).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(downLeftCorner(), upRightCorner());
    }
}
