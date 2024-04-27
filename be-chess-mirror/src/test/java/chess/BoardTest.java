package chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    static Board board;

    @BeforeEach
    @AfterEach
    void clearBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("초기화된 보드의 상태가 체스 규칙* 과 일치함을 확인할 수 있어야 한다")
    void create() {
        board.init();
        String blankRank = appendNewLine("        ");
        assertThat(ChessView.showBoard(board.getBoard())).isEqualTo(
                appendNewLine("♜♞♝♛♚♝♞♜") +
                         appendNewLine("♟♟♟♟♟♟♟♟") +
                         blankRank + blankRank + blankRank + blankRank +
                         appendNewLine("♙♙♙♙♙♙♙♙") +
                         appendNewLine("♖♘♗♕♔♗♘♖"));
    }
}

