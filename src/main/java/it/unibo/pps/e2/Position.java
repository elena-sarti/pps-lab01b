package it.unibo.pps.e2;

public interface Position {

    boolean validatePosition(Pair<Integer,Integer> position);

    boolean validateCoordinate(int coordinate);

    Pair<Integer,Integer> randomEmptyPosition();
}
