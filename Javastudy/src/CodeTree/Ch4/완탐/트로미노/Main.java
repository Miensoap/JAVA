package CodeTree.Ch4.완탐.트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,result;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N+1][M+1];
        for(boolean[] a : visited){
            Arrays.fill(a,false);
        }
        result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(new node(i,j),1, arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    static void dfs(node n, int length, int sum){
        if(length>=3){
            result = Math.max(result, sum);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = n.x+dx[i];
            int ny = n.y+dy[i];

            if(nx<0|| nx>N || ny<0 || ny>M) continue;
            if(!visited[nx][ny]){
                visited[nx][ny]=true;
                dfs(new node(nx,ny),length+1, sum+arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}
class node{
    int x,y;
    node(int x, int y){
        this.x=x;
        this.y=y;
    }
}
