package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    protected abstract Vector2d downLeftCorner();

    protected abstract Vector2d upRightCorner();

    @Override
    public boolean place(Animal animal) {
        if(animals.putIfAbsent(animal.getPosition(), animal) == null){
            animal.addObserver(this);
            return true;
        }else{
            throw new IllegalArgumentException("Position " +
                    animal.getPosition() + " is already occupied.");
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        var animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(downLeftCorner(), upRightCorner());
    }
}
