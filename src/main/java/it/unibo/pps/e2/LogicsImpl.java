package it.unibo.pps.e2;

public class LogicsImpl implements Logics {

    private Pair<Integer, Integer> knight;
    GamePosition gamePosition;

    public LogicsImpl(GamePosition gamePosition) {
        this.gamePosition = gamePosition;
        knight = this.gamePosition.getKnight();
    }

    @Override
    public boolean hit(int row, int col) {
        if (!this.gamePosition.validatePosition(new Pair<>(row, col))) {
            throw new IndexOutOfBoundsException();
        }
        if (isMoveAllowed(row, col)) {
            knight = new Pair<>(row, col);
            return this.gamePosition.getPawn().equals(knight);
        }
        return false;
    }

    @Override
    public boolean isMoveAllowed(int row, int col) {
        int orizontalDistance = GamePosition.getDistance(row, knight.getX());
        int verticalDistance = GamePosition.getDistance(col, knight.getY());
        return orizontalDistance != 0 && verticalDistance != 0 && Math.abs(orizontalDistance) + Math.abs(verticalDistance) == 3;
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return knight.equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.gamePosition.getPawn().equals(new Pair<>(row, col));
    }
}
