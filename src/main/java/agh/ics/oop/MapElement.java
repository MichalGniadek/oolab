package agh.ics.oop;

public abstract class MapElement {
    protected Vector2d position;

    protected MapElement(Vector2d position){this.position = position;}

    public Vector2d getPosition(){
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    protected abstract int GetImportance();

    public static int CompareX(MapElement a, MapElement b){
        var aPos = a.getPosition();
        var bPos = b.getPosition();
        if(aPos.x > bPos.x) return 1;
        else if (aPos.x < bPos.x) return -1;
        else if (aPos.y > bPos.y) return 1;
        else if (aPos.y < bPos.y) return -1;
        else if (a.GetImportance() > b.GetImportance()) return 1;
        else return -1;
    }

    public static int CompareY(MapElement a, MapElement b){
        var aPos = a.getPosition();
        var bPos = b.getPosition();
        if(aPos.y > bPos.y) return 1;
        else if (aPos.y < bPos.y) return -1;
        else if (aPos.x > bPos.x) return 1;
        else if (aPos.x < bPos.x) return -1;
        else if (a.GetImportance() > b.GetImportance()) return 1;
        else return -1;
    }
}
