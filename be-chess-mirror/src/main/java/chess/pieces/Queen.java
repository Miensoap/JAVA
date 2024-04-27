package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;
import static chess.Direction.NORTHWEST;

public class Queen extends Piece{

    protected Queen(Color color) {
        super(color, Type.QUEEN, 8);
    }

    @Override
    protected List<Direction> getDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }
}
