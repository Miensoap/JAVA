package chess;


import chess.pieces.Piece;
import chess.pieces.PieceFactory;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static chess.pieces.Square.getSquare;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChessGameTest {
    ChessGame game;
    Board board;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream output = System.out;
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(output);
    }

    @BeforeEach
    @AfterEach
    void clearGame(){
        this.board = new Board();
        this.game = new ChessGame(board);}

    @ParameterizedTest
    @CsvSource(value = {"move b2 b3", "move b1 c3"})
    @DisplayName("보드의 기물을 움직일 수 있어야 한다")
    void movePiece(String cmd) {
        board.init();
        game.tryMove(cmd);
    }

    @Test
    @DisplayName("비숍은 대각선으로 이동 가능해야 한다")
    void moveBishop(){
        board.init();
        game.tryMove("move d2 d3");
        game.tryMove("move c1 e3"); // 비숍 이동
    }

    @ParameterizedTest
    @CsvSource(value = {"b2 b7" , "a1 a2"})
    @DisplayName("기물의 타입에 따라 움직일 수 없는 경우가 있어야 한다")
    void failToMove(String cmd){
        board.init();
        game.tryMove("move "+cmd);
        System.setOut(new PrintStream(outputStreamCaptor));

        assertThat(outputStreamCaptor.toString()).contains("fail to move");
    }

    @ParameterizedTest
    @CsvSource(value = {"d4 d5" , "e3 e5"})
    @DisplayName("기물의 타입에 따라 움직일 수 없는 경우가 있어야 한다")
    void tryMoveBlack(String cmd){
        board.init();
        game.tryMove("move "+cmd);
        System.setOut(new PrintStream(outputStreamCaptor));

        assertThat(outputStreamCaptor.toString()).contains("not your Piece");
    }

    @Test
    @DisplayName("턴을 진행할 때 본인 색상의 기물만 움직일 수 있어야 한다")
    void turnException(){
        board.init();
        game.tryMove("move d2 d3");
        game.tryMove("move c1 e3"); // 비숍 이동

        System.setOut(new PrintStream(outputStreamCaptor));

        assertThat(outputStreamCaptor.toString()).contains("not your Piece");
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

        assertThat(game.getScore(Color.BLACK)).isCloseTo(15.5, Offset.offset(0.01));
        assertThat(game.getScore(Color.WHITE)).isCloseTo(7.0, Offset.offset(0.01));
    }

    private void addPiece(String position, Piece piece) {
        board.addPieceAt(getSquare(position), piece);
    }
}