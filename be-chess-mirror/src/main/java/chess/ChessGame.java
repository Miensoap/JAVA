package chess;

import chess.pieces.Piece;

import java.util.Arrays;
import java.util.StringTokenizer;

import static chess.ChessHelp.MAX_FILE;
import static chess.ChessHelp.MAX_RANK;
import static chess.pieces.Square.getSquare;

public class ChessGame {
    private final Board gameBoard;
    private int turn = 1;
    public ChessGame(Board board) {
        this.gameBoard = board;
    }

    public void tryMove(String positions) {
        StringTokenizer st = new StringTokenizer(positions, " ");
        st.nextToken();

        Color color;
        if(turn%2 == 1) color = Color.WHITE;
        else color = Color.BLACK;

        try {
            gameBoard.movePiece(getSquare(st.nextToken()), getSquare(st.nextToken()) , color);
        }catch (IllegalArgumentException failMove){
            turn--;
            System.out.println(failMove.getMessage());
        }

        turn++;
        System.out.println("Turn "+turn +" ");
        printView();
    }

    public void printView(){
        System.out.println(ChessView.showBoard(gameBoard.getBoard()));
    }

    public double getScore(Color color) {
        return Arrays.stream(Piece.Type.values())
                .mapToDouble(type -> gameBoard.countPiece(color, type) * type.getScore())
                .sum()
                - countOverPawn(color) * Piece.Type.PAWN.getScore() / 2;
    }

    private int countOverPawn(Color color) {
        int overPawn = 0;
        for (int file = 1; file <= MAX_FILE; file++) {
            int cnt = 0;
            for (int rank = 1; rank <= MAX_RANK; rank++) {
                Piece piece = gameBoard.findPiece(getSquare(rank, file));
                if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
                    cnt++;
                }
            }
            overPawn += cnt > 1 ? cnt : 0; // 점수 빼야 하는 기물 수
        }
        return overPawn;
    }
}
