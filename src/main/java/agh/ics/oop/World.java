package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void main(String[] args) {
//        System.out.println("System wystartował");
//        Direction[] directions = convert(args);
//        run(directions);
//        System.out.println("System zakończył działanie");

        Vector2d pos1 = new Vector2d(1, 2);
        System.out.println(pos1);
        Vector2d pos2 = new Vector2d(-2, 1);
        System.out.println(pos2);
        System.out.println(pos1.add(pos2));
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.NORTH.toUnitVector());
    }

    public static Direction[] convert(String[] args) {
        return Arrays.stream(args).map(arg -> switch (arg) {
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            default -> null;
        }).toArray(Direction[]::new);
    }

    public static void run(Direction[] args) {
        Arrays.stream(args)
                .filter(Objects::nonNull)
                .map(arg -> switch (arg) {
                    case FORWARD -> "Zwierzak idzie do przodu";
                    case BACKWARD -> "Zwierzak idzie do tyłu";
                    case RIGHT -> "Zwierzak skręca w prawo";
                    case LEFT -> "Zwierzak skręca w lewo";
                }).forEach(System.out::println);
    }
}