package CodeTree.Ch2.최단거리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] arr = new char[10][10];
    static Queue<Node> q = new LinkedList<>();
    static int[][] dp = new int[10][10];

    public static boolean indexOk(int r, int c) {
        return r >= 0 && r < 10 && c >= 0 && c < 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            String str = sc.next();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'L') {
                    q.add(new Node(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        int cnt=1;

        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = p.r + dr[i];
                int nextC = p.c + dc[i];
                // R 피해
                if (indexOk(nextR, nextC) && dp[nextR][nextC] == 0 && arr[nextR][nextC] != 'R'){
                    if(arr[nextR][nextC] == 'B') return dp[p.r][p.c];
                    dp[nextR][nextC] = dp[p.r][p.c] + 1;
                    q.add(new Node(nextR, nextC));
                }
            }
        }

        return cnt;
    }

    static class Node {
        int r, c;

        public Node(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
}

