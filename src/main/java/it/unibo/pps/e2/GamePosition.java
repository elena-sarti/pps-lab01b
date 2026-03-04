package it.unibo.pps.e2;

public interface GamePosition {

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

    /**
     *
     *
     * @return the position of the first Pair<Integer, Integer> object
     */
    Pair<Integer, Integer> getPosition1();

    /**
     *
     * @return the position of the second Pair<Integer, Integer> object
     */
    Pair<Integer, Integer> getPosition2();

    /**
     *
     * @param coordinate1
     * @param coordinate2
     * @return the distance between coordinate1 and coordinate2
     */
    public static int getDistance(int coordinate1, int coordinate2){
        return coordinate1 - coordinate2;
    }
}
