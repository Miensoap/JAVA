package chess.pieces;

import chess.Board;
import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;


public class Rook extends Piece{
    private final List<Square> canCastle = List.of(
            Square.getSquare("a1"),
            Square.getSquare("a8"),
            Square.getSquare("h1"),
            Square.getSquare("h8")
    );

    protected Rook(Color color) {
        super(color, Type.ROOK, 8);
    }

    @Override
    protected List<Direction> getDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }


    @Override
    public List<Square> getAvailableSquares(Square start, Board board) {
        // 캐슬링  : 첫 움직임이어야 한다는 조건은 미구현
        List<Square> canMoveSquare = super.getAvailableSquares(start, board);
//        if(canCastle.contains(start)) canMoveSquare.add(checkCanCastle(start, board));

        return canMoveSquare;
    }

//    private Square checkCanCastle(Square start, Board board) {
//        // file a 에서 캐슬링 -> file d 로 이동
//
//    }
}
