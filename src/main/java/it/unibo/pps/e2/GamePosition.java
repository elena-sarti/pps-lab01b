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
     * @return the position of the pawn
     */
    Pair<Integer, Integer> getPawn();

    /**
     *
     * @return the position of the knight
     */
    Pair<Integer, Integer> getKnight();

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
