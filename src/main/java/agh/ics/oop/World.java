package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("system wystartował");
        Direction[] directions = convert(args);
        run(directions);
        out.println("system zakończył działanie");
    }

    public static Direction[] convert(String[] args) {
//        Direction[] directions = new Direction[args.length];
//        int i = 0;
//        for(String arg : args){
//            directions[i] =  switch(arg){
//                case "f" -> Direction.FORWARD;
//                case "b" -> Direction.BACKWARD;
//                case "r" -> Direction.RIGHT;
//                case "l" -> Direction.LEFT;
//                default -> null;
//            };
//            i++;
//        }
//        return directions;

        return Arrays.stream(args).map(arg -> switch (arg) {
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            case "r" -> Direction.RIGHT;
            case "l" -> Direction.LEFT;
            default -> null;
        }).toList().toArray(new Direction[0]);
    }

    public static void run(Direction[] args) {
//        if(input.length > 0){
//            out.print(input[0]);
//            for(String inp : Arrays.copyOfRange(input, 1, input.length)){
//                out.print(", ");
//                out.print(inp);
//            }
//            out.println();
//        }

//        for (Direction arg : args) {
//            String message = switch (arg) {
//                case FORWARD -> "Zwierzak idzie do przodu";
//                case BACKWARD -> "Zwierzak idzie do tyłu";
//                case RIGHT -> "Zwierzak skręca w prawo";
//                case LEFT -> "Zwierzak skręca w lewo";
//                default -> "Nieznana komenda";
//            };
//
//            if (!message.equals("Nieznana komenda")) {
//                out.println(message);
//            }
//        }

        Arrays.stream(args)
                .filter(Objects::nonNull)
                .map(arg -> switch (arg) {
                    case FORWARD -> "Zwierzak idzie do przodu";
                    case BACKWARD -> "Zwierzak idzie do tyłu";
                    case RIGHT -> "Zwierzak skręca w prawo";
                    case LEFT -> "Zwierzak skręca w lewo";
                }).forEach(out::println);
    }
}