package chess.pieces;

import chess.Board;
import chess.Color;
import chess.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;
import static chess.pieces.Square.getSquare;

public class Pawn extends Piece {
    protected Pawn(Color color) {
        super(color, Type.PAWN, 1);
    }

    @Override
    protected List<Direction> getDirection() {
        if (isWhite()) return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
        else return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }

    protected List<Square> checkCanMove(Square start, Direction D, int count, Board board) {
        // 첫 움직임이면 앞으로는 2 칸 이동 가능
        if ((start.rankIndex() == 6 && isWhite() || (start.rankIndex() == 1 && isBlack()))) count += 1;
        List<Square> canMoveSquares = new ArrayList<>(checkPawnFrontMove(start, D, count, board));

        Square target;
        Piece pieceAtTarget;

        for (int i = 1; i <= 2; i++) { // 양쪽 대각선 이동은 상대방 말이 있어야 가능하다
            try {
                target = getSquare(start, getDirection().get(i));
                pieceAtTarget = board.findPiece(target);
                if (pieceAtTarget.getColor() != this.getColor() && pieceAtTarget.getColor() != Color.NOCOLOR)
                    canMoveSquares.add(target);
            } catch (IllegalArgumentException outRange) { // 한쪽이 outRange 실패해도 나머지 대각선 확인해야 한다
            }
        }

        return canMoveSquares;
    }

    private List<Square> checkPawnFrontMove(Square start, Direction D, int count, Board board) {
        List<Square> canMoveSquares = new ArrayList<>();
        Square target;
        for (int i = 0; i < count; i++) {
            try {
                target = getSquare(start, D); // inRange 검증
            } catch (IllegalArgumentException outRange) {
                return canMoveSquares;
            }

            Piece pieceAtTarget = board.findPiece(target);
            if (pieceAtTarget.getType() == Piece.Type.BLANK) { // 빈칸이라면 이동 가능 , 다음 확인 위해 재귀 호출
                canMoveSquares.add(target);
                checkPawnFrontMove(target, D, count + 1, board);
            }
        }

        return canMoveSquares;
    }
}
