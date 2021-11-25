package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private static final Random rand = new Random();
    private List<Grass> grass = new ArrayList<>();

    public GrassField(int count) {
        int range = (int) sqrt(count * 10);
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
        Vector2d corner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (var a : animals) {
            corner = corner.lowerLeft(a.getPosition());
        }
        for(var g : grass){
            corner = corner.lowerLeft(g.getPosition());
        }
        return corner;
    }

    @Override
    protected Vector2d upRightCorner() {
        Vector2d corner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (var a : animals) {
            corner = corner.upperRight(a.getPosition());
        }
        for(var g : grass){
            corner = corner.upperRight(g.getPosition());
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
