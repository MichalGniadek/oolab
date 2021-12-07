package agh.ics.oop;

public class Grass extends MapElement{
    public Grass(Vector2d position){
        super(position);
    }

    @Override
    protected int GetImportance() {
        return 0;
    }

    @Override
    public String toString() {
        return "*";
    }
}
