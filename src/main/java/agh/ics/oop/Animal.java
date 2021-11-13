package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> tryMoveTo(position.add(this.direction.toUnitVector()));
            case BACKWARD -> tryMoveTo(position.add(this.direction.toUnitVector().opposite()));
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }

    private void tryMoveTo(Vector2d newPosition) {
        if (map.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
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
}
