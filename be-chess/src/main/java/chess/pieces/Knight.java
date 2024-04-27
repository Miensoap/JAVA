package chess.pieces;

import chess.Color;
import chess.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.Direction.*;

public class Knight extends Piece {

    protected Knight(Color color) {
        super(color, Type.KNIGHT,1 );
    }

    @Override
    public List<Direction> getDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }
}
