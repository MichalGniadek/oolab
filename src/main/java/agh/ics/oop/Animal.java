package agh.ics.oop;

import java.util.HashSet;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    private static HashSet<Vector2d> occupied = new HashSet<Vector2d>();

    public Animal() {
        if (occupied.contains(position)) {
            throw new IllegalStateException();
        }
        occupied.add(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD -> tryMoveTo(position.add(this.direction.toUnitVector()));
            case BACKWARD -> tryMoveTo(position.add(this.direction.toUnitVector().opposite()));
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }

    private void tryMoveTo(Vector2d new_pos) {
        if (new_pos.follows(new Vector2d(0, 0)) &&
                new_pos.precedes(new Vector2d(4, 4)) &&
                !occupied.contains(new_pos)) {
            occupied.remove(position);
            occupied.add(new_pos);
            position = new_pos;
        }
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return position + " " + direction;
    }
}
