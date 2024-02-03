package BackJ.P7569_토마토2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H;
    static int[][][] box;
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static Queue<tomato> queue = new LinkedList<tomato>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        for(int h=0; h<H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    box[h][i][j] = num;
                    if (num == 1) {
                        queue.add(new tomato(i, j,h));
                    }
                }
            }
        }
        BFS();

        int result = Integer.MIN_VALUE;
        for(int h=0; h<H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    result = Math.max(result, box[h][i][j]);
                }
            }
        }
        if (result == 1) System.out.println(0);
        else System.out.println(result - 1);


    }
    private static void BFS(){
            while (!queue.isEmpty()){
                tomato t = queue.poll();
                for(int i=0; i<6; i++){
                    int nx = t.x+dx[i];
                    int ny = t.y+dy[i];
                    int nh = t.h+dh[i];
                    if(!inRange(nx,ny,nh)) continue;

                    if(box[nh][nx][ny]==0){
                        queue.add(new tomato(nx,ny,nh));
                        box[nh][nx][ny] = box[t.h][t.x][t.y] +1;
                    }
                }
            }
    }
    private static boolean inRange(int x, int y, int h) {return x >= 0 && y >= 0 && x < N && y < M && h>=0 && h<H;}
}

class tomato{
    int x,y,h;
    tomato(int x, int y, int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
