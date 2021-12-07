package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    Vector2d size;

    public RectangularMap(int width, int height) {
        size = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.precedes(size) &&
                !isOccupied(position);
    }

    @Override
    protected Vector2d downLeftCorner() {
        return new Vector2d(0, 0);
    }

    @Override
    protected Vector2d upRightCorner() {
        return size;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }
}
