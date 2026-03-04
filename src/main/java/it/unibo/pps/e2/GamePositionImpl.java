package it.unibo.pps.e2;

import java.util.Random;

public class GamePositionImpl implements GamePosition {

    private final int size;
    private final Random random = new Random();
    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;

    public GamePositionImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knight){
        this.size = size;
        this.pawn = validatePosition(pawn) ? pawn : randomEmptyPosition();
        this.knight = validatePosition(knight) && !this.pawn.equals(knight) ? knight : randomEmptyPosition();
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
        return pos.equals(this.pawn) ? randomEmptyPosition() : pos;
    }

    @Override
    public Pair<Integer, Integer> getPawn(){
        return this.pawn;
    }

    @Override
    public Pair<Integer, Integer> getKnight(){
        return this.knight;
    }
}
