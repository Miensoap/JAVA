package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;


public class Rook extends Piece{
    protected Rook(Color color) {
        super(color, Type.ROOK, 8);
    }

    @Override
    public List<Direction> getDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }


}
