package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;

public class King extends Piece{
    protected King(Color color) {
        super(color, Type.KING, 1);
    }

    @Override
    protected List<Direction> getDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }
}
