package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private static final Random rand = new Random();
    private Map<Vector2d, Grass> grass = new HashMap<>();
    private MapBoundary boundary = new MapBoundary();

    public GrassField(int count) {
        int range = (int) sqrt(count * 10);
        for (int i = 0; i < count; i++) {
            Vector2d pos;

            do {
                pos = new Vector2d(rand.nextInt(range), rand.nextInt(range));
            }while(grass.containsKey(pos));

            var g = new Grass(pos);
            grass.put(pos, g);
            boundary.place(g);
        }
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        boundary.place(animal);
        animal.addObserver(boundary);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animals.get(position) == null;
    }

    @Override
    protected Vector2d downLeftCorner() {
        return boundary.downLeftCorner();
    }

    @Override
    protected Vector2d upRightCorner() {
        return boundary.upRightCorner();
    }

    @Override
    public Object objectAt(Vector2d position) {
        var animal = animals.get(position);
        return animal != null ? animal : grass.get(position);
    }
}
