package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;

public class Bishop extends Piece{
    protected Bishop(Color color) {
        super(color, Type.BISHOP, 8);
    }
    @Override
    public List<Direction> getDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }
}
