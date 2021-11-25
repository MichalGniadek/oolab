package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private static final Random rand = new Random();
    private final int range;
    private List<Grass> grass = new ArrayList<>();

    public GrassField(int count) {
        range = (int) sqrt(count * 10);
        for (int i = 0; i < count; i++) {
            Vector2d pos;

            do {
                pos = new Vector2d(rand.nextInt(range), rand.nextInt(range));
            }while(grassAt(pos) != null);

            grass.add(new Grass(pos));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animalAt(position) == null;
    }

    @Override
    protected Vector2d downLeftCorner() {
        Vector2d corner = new Vector2d(0, 0);
        for (var a : animals) {
            corner = corner.lowerLeft(a.getPosition());
        }
        return corner;
    }

    @Override
    protected Vector2d upRightCorner() {
        Vector2d corner = new Vector2d(range, range);
        for (var a : animals) {
            corner = corner.upperRight(a.getPosition());
        }
        return corner;
    }

    @Override
    public Object objectAt(Vector2d position) {
        var animal = animalAt(position);
        if (animal != null) {
            return animal;
        } else {
            return grassAt(position);
        }
    }

    public Object grassAt(Vector2d position) {
        return grass.stream().filter(a -> a.getPosition().equals(position)).findAny().orElse(null);
    }
}
