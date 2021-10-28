package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void main(String[] args) {
        var animal = new Animal();
        var directions = OptionsParser.parse(args);
        for(var dir : directions){
            animal.move(dir);
            System.out.print(animal);
        }
    }
}