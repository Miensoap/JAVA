package chess;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0, -1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1),

    NNE(1, 2),
    NNW(-1, 2),
    SSE(1, -2),
    SSW(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1),

    EEE(3,0),
    EE(2,0),
    WW(-2,0);
    ;



    private final int fileMove;
    private final int rankMove;

    Direction(int fileMove, int rankMove) {
        this.fileMove = fileMove;
        this.rankMove = rankMove;
    }

    public int getFileMove() {
        return fileMove;
    }

    public int getRankMove() {
        return rankMove;
    }
}
