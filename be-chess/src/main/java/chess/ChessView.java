package chess;

import java.util.List;
import java.util.StringJoiner;

import static utils.StringUtils.appendNewLine;

public class ChessView {
    // 출력
    public static String showBoard(List<Rank> board) {
        StringBuilder sb = new StringBuilder();
        board.forEach(rank -> sb.append(appendNewLine(getRankResult(rank))));
        return sb.toString();
    }

    private static String getRankResult(Rank rank) {
        StringJoiner sj = new StringJoiner("");
        rank.stream().forEach(p -> sj.add(p.getRepresentation()));

        return sj.toString();
    }
}
