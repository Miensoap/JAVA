package chess;

import java.util.StringTokenizer;

import static chess.pieces.Square.getSquare;

public class ChessGame {
    private final Board gameBoard;
    private int turn = 1;
    private Color color = Color.WHITE;
    public ChessGame(Board board) {
        this.gameBoard = board;
    }

    public void tryMove(String positions) {
        StringTokenizer st = new StringTokenizer(positions, " ");
        st.nextToken();
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
}
