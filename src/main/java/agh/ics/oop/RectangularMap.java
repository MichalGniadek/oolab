package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    Vector2d size;

    public RectangularMap(int width, int height) {
        super();
        size = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0)) &&
                position.precedes(size) &&
                !isOccupied(position);
    }

    @Override
    protected Vector2d minSize() {
        return new Vector2d(0, 0);
    }

    @Override
    protected Vector2d maxSize() {
        return size;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.stream().filter(a -> a.isAt(position)).findAny().orElse(null);
    }
}
