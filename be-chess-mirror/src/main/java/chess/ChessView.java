package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    // 출력
    public static String showBoard(List<Rank> board) {
        StringBuilder sb = new StringBuilder();
        board.forEach(rank -> sb.append(appendNewLine(rank.getRankRepresentation(rank))));
        return sb.toString();
    }

    public static List<Piece> getPieceList(List<Rank> board) {
        List<Piece> pieceList = new ArrayList<>();
        board.forEach(R -> pieceList.addAll(R.getPieceList()));
        return pieceList;
    }
}
