package it.unibo.pps.e2;

import java.util.Random;

public class PositionImpl implements Position {

    public int size;
    private final Random random = new Random();
    public final Pair<Integer, Integer> object1;
    public Pair<Integer, Integer> object2;

    public PositionImpl(int size, Pair<Integer, Integer> object1, Pair<Integer, Integer> object2){
        this.size = size;
        this.object1 = validatePosition(object1) ? object1 : randomEmptyPosition();
        this.object2 = validatePosition(object2) && !this.object1.equals(object2) ? object2 : randomEmptyPosition();
    }

    @Override
    public boolean validatePosition(Pair<Integer, Integer> object) {
        return validateCoordinate(object.getX()) && validateCoordinate(object.getY());
    }

    @Override
    public boolean validateCoordinate(int coordinate){
        return coordinate>=0 && coordinate<size;
    }

    @Override
    public final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing object
        return pos.equals(this.object1) ? randomEmptyPosition() : pos;
    }

    public static int getDistance(int coordinate1, int coordinate2){
        return coordinate1 - coordinate2;
    }
}
