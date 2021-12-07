package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends MapElement{
    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;
    private List<IPositionChangeObserver> observerList = new ArrayList<>();

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d position) {
        super(position);
        this.map = map;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> tryMoveTo(position.add(this.direction.toUnitVector()));
            case BACKWARD -> tryMoveTo(position.add(this.direction.toUnitVector().opposite()));
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }

    private void tryMoveTo(Vector2d newPosition) {
        if (map.canMoveTo(newPosition)) {
            Vector2d oldPosition = position;
            position = newPosition;
            positionChanged(oldPosition, newPosition);
        }
    }

    private void positionChanged (Vector2d oldPosition, Vector2d newPosition) {
        for(var o : observerList) o.positionChanged(oldPosition, newPosition);
    }

    @Override
    public String toString() {
        return switch (direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    @Override
    protected int GetImportance() {
        return 10;
    }
}
