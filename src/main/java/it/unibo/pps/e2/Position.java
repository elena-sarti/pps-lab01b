package it.unibo.pps.e2;

public interface Position {

     /**
     * @param position
     * @return whether the position of an object is valid
     */
    boolean validatePosition(Pair<Integer,Integer> position);

    /**
     * @param coordinate
     * @return whether a coordinate of a position is valid
     */
    boolean validateCoordinate(int coordinate);

    /**
     *
     * @return a new position with valid coordinates
     */
    Pair<Integer,Integer> randomEmptyPosition();
}
