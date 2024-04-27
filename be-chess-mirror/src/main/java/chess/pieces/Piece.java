package chess.pieces;

import chess.Board;
import chess.Color;
import chess.Direction;
import chess.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static chess.pieces.Square.getSquare;

public abstract class Piece {
    public final Type type;
    private final Color color;
    private final String representation;
    private final int canMove;

    protected Piece(Color color, Type type, int canMove) {
        this.color = color;
        this.type = type;
        this.canMove = canMove;
        if (isBlack()) this.representation = String.valueOf((char) (type.getRepresentation().charAt(0) + 6));
        else this.representation = type.getRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public Type getType() {
        return this.type;
    }

    public String getRepresentation() {
        return this.representation;
    }

    protected abstract List<Direction> getDirection();

    public List<Square> getAvailableSquares(Square start , Board board) {
        List<Square> squares = new ArrayList<>();
        getDirection().forEach(D -> {
            squares.addAll(checkCanMove(start, D, 0, board));
        });
        return squares;
    }

    List<Square> checkCanMove(Square start, Direction D, int count, Board board) {
        List<Square> canMoveSquares = new ArrayList<>();
        if (count == this.canMove) return canMoveSquares;

        Square target;
        try {
            target = getSquare(start, D); // inRange 검증
        } catch (IllegalArgumentException outRange) {
            return canMoveSquares;
        }

        Piece pieceAtTarget = board.findPiece(target);
        if (pieceAtTarget.getType() == Piece.Type.BLANK) { // 빈칸이라면 이동 가능 , 다음 확인 위해 재귀 호출
            canMoveSquares.add(target);
            checkCanMove(target, D, count + 1, board);
        }

        // 다른 색이면 거기까지 추가 , 같은 색이면 추가 안하고 그만
        if (pieceAtTarget.getColor() != this.color) canMoveSquares.add(target);
        return canMoveSquares;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    public enum Type {
        PAWN(1.0, "♙"),
        KNIGHT(2.5, "♘"),
        ROOK(5.0, "♖"),
        BISHOP(3.0, "♗"),
        QUEEN(9.0, "♕"),
        KING(0, "♔"),
        BLANK(0, " ");

        private final double score;
        final String representation;

        Type(double score, String representation) {
            this.score = score;
            this.representation = representation;
        }

        public double getScore() {
            return score;
        }

        public String getRepresentation() {
            return representation;
        }
    }
}
