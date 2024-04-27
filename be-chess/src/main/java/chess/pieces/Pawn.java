package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;

public class Pawn extends Piece{
    protected Pawn(Color color){
        super(color , Type.PAWN, 1);
    }

    @Override
    public List<Direction> getDirection() {
        if(isWhite()) return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
        else return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }
}
