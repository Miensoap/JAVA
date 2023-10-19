package BackJ.P7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] box;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<tomato> queue = new LinkedList<tomato>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                box[i][j] = num;
                if (num==1){
                    queue.add(new tomato(i,j));
                }
            }
        }
        BFS();

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                result = Math.max(result, box[i][j]);
            }
        }
        if (result == 1) System.out.println(0);
        else System.out.println(result - 1);


    }
    private static void BFS(){
            while (!queue.isEmpty()){
                tomato t = queue.poll();
                for(int i=0; i<4; i++){
                    int nx = t.x+dx[i];
                    int ny = t.y+dy[i];
                    if(!inRange(nx,ny)) continue;

                    if(box[nx][ny]==0){
                        queue.add(new tomato(nx,ny));
                        box[nx][ny] = box[t.x][t.y] +1;
                    }
                }
            }
    }
    private static boolean inRange(int x, int y) {return x >= 0 && y >= 0 && x < N && y < M;}
}

class tomato{
    int x,y;
    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
