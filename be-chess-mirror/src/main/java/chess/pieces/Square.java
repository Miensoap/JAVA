package chess.pieces;

import chess.Direction;

import static chess.ChessHelp.*;

public class Square {
    private final int rankIndex , fileIndex; // 0 ~ 7 범위의 인덱스
    private Square(int rankIndex , int fileIndex){
        this.rankIndex = rankIndex;
        this.fileIndex = fileIndex;
    }

    public int rankIndex(){
        return this.rankIndex;
    }

    public int fileIndex(){
        return this.fileIndex;
    }


    public static Square getSquare(String position) { // a1 형태 기보 로부터 Square
        int rankIndex = MAX_RANK - Integer.parseInt(position.substring(1));
        int fileIndex = position.charAt(0) - 'a';

        return verifyRange(rankIndex, fileIndex);
    }

    public static Square getSquare(int rank, int file) { // 1~8 로 표현한 rank , file 로부터 Square
        int rankIndex = MAX_RANK - rank;
        int fileIndex = file - MIN_FILE;

        return verifyRange(rankIndex, fileIndex);
    }

    public static Square getSquare(Square square, Direction direction) { // 시작 지점 , 움직임 으로부터 Square
        int rankIndex = square.rankIndex() - direction.getRankMove();
        int fileIndex = square.fileIndex() + direction.getFileMove();

        return verifyRange(rankIndex, fileIndex);
    }

    private static Square verifyRange(int rankIndex, int fileIndex) {
        // 인덱스는 0 ~ 7 사이 값임을 검증
        if (!(rankIndex >= MIN_RANK - 1 && fileIndex >= MIN_FILE -1 && rankIndex < MAX_RANK && fileIndex < MAX_FILE)) throw new IllegalArgumentException("outRange Square");
        return new Square(rankIndex, fileIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return rankIndex == square.rankIndex && fileIndex == square.fileIndex;
    }

}
