package chess;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

        Assertions.assertThat(outputStreamCaptor.toString()).contains("fail to move");
    }

    @ParameterizedTest
    @CsvSource(value = {"d4 d5" , "e3 e5"})
    @DisplayName("기물의 타입에 따라 움직일 수 없는 경우가 있어야 한다")
    void tryMoveBlack(String cmd){
        board.init();
        game.tryMove("move "+cmd);
        System.setOut(new PrintStream(outputStreamCaptor));

        Assertions.assertThat(outputStreamCaptor.toString()).contains("not your Piece");
    }

    @Test
    @DisplayName("턴을 진행할 때 본인 색상의 기물만 움직일 수 있어야 한다")
    void turnException(){
        board.init();
        game.tryMove("move d2 d3");
        game.tryMove("move c1 e3"); // 비숍 이동

        System.setOut(new PrintStream(outputStreamCaptor));

        Assertions.assertThat(outputStreamCaptor.toString()).contains("not your Piece");
    }

}