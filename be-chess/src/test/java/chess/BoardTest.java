package chess;

import chess.pieces.Piece;
import chess.pieces.PieceFactory;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.pieces.Square.getSquare;
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

    @Test
    @DisplayName("점수 규칙* 에 따라 각 색상별 기물 점수를 계산할 수 있어야 한다")
    void calculatePoint() {
        addPiece("b6", PieceFactory.createBlackPawn());
        addPiece("e6", PieceFactory.createBlackQueen());
        addPiece("b8", PieceFactory.createBlackKing());
        addPiece("c8", PieceFactory.createBlackRook());
        addPiece("b4", PieceFactory.createBlackPawn());
        addPiece("b3", PieceFactory.createBlackPawn());

        addPiece("f2", PieceFactory.createWhitePawn());
        addPiece("g2", PieceFactory.createWhitePawn());
        addPiece("e1", PieceFactory.createWhiteRook());
        addPiece("f1", PieceFactory.createWhiteKing());

        assertThat(board.getScore(Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(board.getScore(Color.WHITE)).isCloseTo(7.0, Offset.offset(0.01));
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(getSquare(position), piece);
    }
}

