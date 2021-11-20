package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    protected abstract Vector2d minSize();
    protected abstract Vector2d maxSize();

    @Override
    public boolean place(Animal animal) {
        return animals.add(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(minSize(), maxSize());
    }
}
