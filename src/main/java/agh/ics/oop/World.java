package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void main(String[] args) {
        // Animal collisions
//        var a1 = new Animal();
//        a1.move(MoveDirection.FORWARD);
//        var a2 = new Animal();
//        System.out.println(a1);
//        a2.move(MoveDirection.FORWARD);
//        System.out.println(a1);

        // Lab 3
        var animal = new Animal();
        var directions = OptionsParser.parse(args);
        for(var dir : directions){
            animal.move(dir);
            System.out.println(animal);
        }
    }
}