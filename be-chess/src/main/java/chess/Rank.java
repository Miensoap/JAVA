package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static chess.ChessHelp.MAX_FILE;
import static chess.ChessHelp.MIN_FILE;

public class Rank {
    final List<Piece> rank = new ArrayList<>(MAX_FILE);

    public Rank() { // 기본값 : 다 비워져있음
        for (int file = MIN_FILE; file <= MAX_FILE; file++) {
            this.rank.add(PieceFactory.createBlank());
        }
    }

    public Piece getPiece(int fileIndex) {
        return rank.get(fileIndex);
    }

    public void setPiece(int fileIndex, Piece piece) {
        rank.set(fileIndex , piece);
    }

    public Stream<Piece> stream() {
        return rank.stream();
    }
}
