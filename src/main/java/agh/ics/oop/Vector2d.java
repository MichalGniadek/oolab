package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    final int x;
    final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
       return  "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other){
        return other.precedes(this);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Integer.max(this.x, other.x), Integer.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Integer.min(this.x, other.x), Integer.min(this.y, other.y));
    }

    public Vector2d add(Vector2d other){
        return  new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d substract(Vector2d other){
        return  new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d o = (Vector2d) other;
        return this.x == o.x && this.y == o.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
