import chess.Board;
import chess.ChessGame;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class GameLauncher {
    static ChessGame game;
    static Pattern moveRegex = Pattern.compile("move( [a-h][1-8]){2}");
    public static void main(String[] args) {
        runChessCmd();
    }
    static void runChessCmd() {
        Scanner sc = new Scanner(System.in);

        printHelp();
        while (true){
            System.out.print("Chess>> ");
            String input = sc.nextLine();

            if(input.equals("start") && game==null) runGame();
            else if(moveRegex.matcher(input).matches() && game!=null) game.tryMove(input);
            else if(input.equals("end")) {
                System.out.println("GoodBye");
                return;
            }
            else System.out.println("잘못된 명령입니다.");
        }
    }

    private static void printHelp() {
        System.out.println("""
                     <체스 게임>
            ---------------------------
             게임을 시작하려면 start 입력
             게임을 종료하려면 end 입력
                                        
             게임 시작후 기물을 이동하려면
             move a1 a2 형식 입력
            ---------------------------
            """);
    }
    private static void runGame() {
        Board board = new Board();
        board.init();
        game = new ChessGame(board);
        game.printView();
    }
}
