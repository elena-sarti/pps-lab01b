package it.unibo.pps.e2;

public class LogicsImpl implements Logics {

    public final Pair<Integer, Integer> pawn;
    public Pair<Integer, Integer> knight;
    PositionImpl position;

    public LogicsImpl(PositionImpl position) {
        this.position = position;
        this.pawn = this.position.object1;
        this.knight = this.position.object2;
    }

    @Override
    public boolean hit(int row, int col) {
        if (!this.position.validatePosition(new Pair<>(row, col))) {
            throw new IndexOutOfBoundsException();
        }
        int orizontalDistance = PositionImpl.getDistance(row, this.knight.getX());
        int verticalDistance = PositionImpl.getDistance(col, this.knight.getY());
        if (isMoveAllowed(orizontalDistance, verticalDistance)) {
            this.knight = new Pair<>(row, col);
            return this.pawn.equals(this.knight);
        }
        return false;
    }

    @Override
    public boolean isMoveAllowed(int orizontalDistance, int verticalDistance) {
        return orizontalDistance != 0 && verticalDistance != 0 && Math.abs(orizontalDistance) + Math.abs(verticalDistance) == 3;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row, col));
    }
}
