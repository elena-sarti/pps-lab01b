package it.unibo.pps.e2;

public class LogicsImpl implements Logics {

    private final Pair<Integer, Integer> pawn;
    private Pair<Integer, Integer> knight;
    GamePosition position;

    public LogicsImpl(GamePosition position) {
        this.position = position;
        this.pawn = this.position.getPosition1();
        this.knight = this.position.getPosition2();
    }

    @Override
    public boolean hit(int row, int col) {
        if (!this.position.validatePosition(new Pair<>(row, col))) {
            throw new IndexOutOfBoundsException();
        }
        int orizontalDistance = GamePosition.getDistance(row, this.knight.getX());
        int verticalDistance = GamePosition.getDistance(col, this.knight.getY());
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
