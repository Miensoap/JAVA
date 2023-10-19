package BackJ.P10711_모래성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[][] land;
    static int[][] days;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static Queue<castle> queue = new LinkedList<castle>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        land = new String[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                String s = ch[j]+"";
                land[i][j] = s;
            }
        }

        days = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isCollapse(i, j)) days[i][j] = 1;
            }
        }
        BFS();

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, days[i][j]);
            }
        }
        System.out.println(result);
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            castle c = queue.poll();
            int x = c.x;
            int y = c.y;
            land[x][y] = ".";
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!inRange(nx, ny)) continue;
                if (isCollapse(nx, ny)) days[nx][ny] = days[x][y] + 1;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static boolean isCollapse(int x, int y) {
        if(land[x][y].equals(".")) return false;
        if(days[x][y]!=0) return false;
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inRange(nx, ny)) continue;
            if (land[nx][ny].equals(".")) cnt += 1;
        }
        if (Integer.parseInt(land[x][y]) <= cnt) {
            queue.add(new castle(x, y));
            return true;
        }
        return false;
    }
}


class castle {
    int x, y;
    public castle(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
