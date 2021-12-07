package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    SortedSet<MapElement> xSet = new TreeSet<MapElement>(MapElement::CompareX);
    SortedSet<MapElement> ySet = new TreeSet<MapElement>(MapElement::CompareY);

    public void place(MapElement e){
        xSet.add(e);
        ySet.add(e);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        var xIter = xSet.iterator();
        while (xIter.hasNext()){
            var e = xIter.next();
            if(e.isAt(newPosition)){
                xIter.remove();
                xSet.add(e);
                break;
            }
        }

        var yIter = ySet.iterator();
        while (yIter.hasNext()){
            var e = yIter.next();
            if(e.isAt(newPosition)){
                yIter.remove();
                ySet.add(e);
                break;
            }
        }
    }

    protected Vector2d downLeftCorner() {
        return new Vector2d(
                xSet.first().getPosition().x,
                ySet.first().getPosition().y
        );
    }

    protected Vector2d upRightCorner() {
        return new Vector2d(
                xSet.last().getPosition().x,
                ySet.last().getPosition().y
        );
    }
}
