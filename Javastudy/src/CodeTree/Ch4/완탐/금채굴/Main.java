package CodeTree.Ch4.완탐.금채굴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K,result;
    static int[][] arr;
    static Queue<node> queue;
    static int[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        queue = new LinkedList<node>();
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                int k=2;
                while(true) {
                    setVisited();
                    queue.add(new node(i, j));
                    visited[i][j] = 1;
                    int gold = bfs(k);
                    if (gold*M>= getArea(k)){
                        result = Math.max(result,gold);
                        k++;
                    }
                    else break;
                }
            }
        }
        System.out.println(result);
    }
    static void setVisited(){
        visited = new int[N][N];
        for(int[] a : visited){
            Arrays.fill(a,0);
        }
    }

    public static int getArea(int k) {
        return k * k + (k+1) * (k+1);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static int bfs(int K) {
        int gold = 0;
        while (!queue.isEmpty()) {
            node n = queue.poll();
            if (arr[n.x][n.y] == 1) gold++;
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (!inRange(nx, ny)) continue;

                if (visited[nx][ny] == 0 && visited[n.x][n.y] < K) {
                    visited[nx][ny] = visited[n.x][n.y] + 1;
                    queue.add(new node(nx, ny));
                }
            }
        }
        return gold;
    }
}
class node{
    int x,y;
    node(int x, int y){
        this.x=x;
        this.y=y;
    }
}
