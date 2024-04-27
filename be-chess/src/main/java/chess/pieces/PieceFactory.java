package chess.pieces;

import static chess.Color.*;

public class PieceFactory {

    public static Piece createWhitePawn() {
        return new Pawn(WHITE);
    }

    public static Piece createBlackPawn() { return new Pawn(BLACK); }

    public static Piece createWhiteKnight() {
        return new Knight(WHITE);
    }

    public static Piece createBlackKnight() {
        return new Knight(BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Bishop(WHITE);
    }

    public static Piece createBlackBishop() {
        return new Bishop(BLACK);
    }

    public static Piece createWhiteRook() {
        return new Rook(WHITE);
    }

    public static Piece createBlackRook() {
        return new Rook(BLACK);
    }

    public static Piece createWhiteQueen() {
        return new Queen(WHITE);
    }

    public static Piece createBlackQueen() {
        return new Queen(BLACK);
    }

    public static Piece createWhiteKing() {
        return new King(WHITE);
    }

    public static Piece createBlackKing() {
        return new King(BLACK);
    }

    public static Piece createBlank() {
        return new Blank();
    }

}
