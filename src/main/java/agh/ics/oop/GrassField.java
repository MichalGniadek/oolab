package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private static final Random rand = new Random();
    private int range;
    private List<Grass> grass = new ArrayList<>();

    public GrassField(int count) {
        super();
        range = (int) sqrt(count * 10);
        for (int i = 0; i < count; i++){
            Vector2d pos;
            while(true) {
                pos = new Vector2d(rand.nextInt(range), rand.nextInt(range));

                boolean should_break = true;
                for (var g: grass) {
                    if (g.getPosition().equals(pos)){
                        should_break = false;
                        break;
                    }
                }

                if(should_break){
                    break;
                }
            }

            grass.add(new Grass(pos));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animals.stream().filter(a -> a.isAt(position)).findAny().orElse(null) == null;
    }

    @Override
    protected Vector2d minSize() {
        Vector2d min = new Vector2d(0, 0);
        for (var a : animals) {
            var pos = a.getPosition();
            min = new Vector2d(
                    Math.min(min.x, pos.x),
                    Math.min(min.y, pos.y)
            );
        }
        return min;
    }

    @Override
    protected Vector2d maxSize() {
        Vector2d max = new Vector2d(range, range);
        for (var a : animals) {
            var pos = a.getPosition();
            max = new Vector2d(
                    Math.max(max.x, pos.x),
                    Math.max(max.y, pos.y)
            );
        }
        return max;
    }

    @Override
    public Object objectAt(Vector2d position) {
        var animal = animals.stream().filter(a -> a.isAt(position)).findAny().orElse(null);
        if (animal != null) {
            return animal;
        } else {
            return grass.stream().filter(a -> a.getPosition().equals(position)).findAny().orElse(null);
        }
    }
}
