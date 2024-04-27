package chess.pieces;

import chess.Color;
import chess.Direction;
import java.util.ArrayList;
import java.util.List;

public class Blank extends Piece{

    protected Blank() {
        super(Color.NOCOLOR, Type.BLANK, 0);
    }

    public List<Direction> getDirection() {
        return new ArrayList<>();
    }
}