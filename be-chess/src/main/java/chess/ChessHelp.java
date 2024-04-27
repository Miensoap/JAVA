package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import java.util.List;
import java.util.function.Supplier;

public class ChessHelp {
    public static final int MIN_RANK = 1;
    public static final int MIN_FILE = 1;
    public static final int MAX_RANK = 8;
    public static final int MAX_FILE = 8;

    static final List<Supplier<Piece>> blackPieceSequence = List.of(
            PieceFactory::createBlackRook,
            PieceFactory::createBlackKnight,
            PieceFactory::createBlackBishop,
            PieceFactory::createBlackQueen,
            PieceFactory::createBlackKing,
            PieceFactory::createBlackBishop,
            PieceFactory::createBlackKnight,
            PieceFactory::createBlackRook
    );

    static final List<Supplier<Piece>> whitePieceSequence = List.of(
            PieceFactory::createWhiteRook,
            PieceFactory::createWhiteKnight,
            PieceFactory::createWhiteBishop,
            PieceFactory::createWhiteQueen,
            PieceFactory::createWhiteKing,
            PieceFactory::createWhiteBishop,
            PieceFactory::createWhiteKnight,
            PieceFactory::createWhiteRook
    );
}
