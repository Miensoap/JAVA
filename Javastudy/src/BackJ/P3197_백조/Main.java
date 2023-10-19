package BackJ.P3197_백조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int N,M;
    static  int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;

    static boolean[][] visited;
    static Queue<Pair> q;
    static Queue<Pair> bird = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        String str = " ";

        for(int i = 0; N>i; i++){
            str = reader.readLine();
            arr[i] = str.toCharArray();
        }

        visited =  new boolean[N][M];
        q = new LinkedList<>();

        // 녹을얼음을 찾아서 넣어
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]=='X'){
                    for(int k=0;k<4;k++){
                       int nx = i + dx[k];
                       int ny = j + dy[k];

                       if(nx<0 || ny<0 || nx>=N || ny>=M)
                        continue;

                       if(arr[nx][ny]=='.'|| arr[nx][ny]=='L'){
                            q.add(new Pair(i,j));
                            break;
                       }
                    }
                }
                else if(arr[i][j]=='L'){
                    bird.add(new Pair(i,j));
                }

            }
        }
        bird.poll();

        while (true){
            bird_bfs();
            if (!q.isEmpty())ice_bfs();
            result++;
        }






    }

    public static void ice_bfs(){
        Queue<Pair> q1= new LinkedList<>(q);
        boolean[][] visited =  new boolean[N][M];
        q = new LinkedList<>();

       while(!q1.isEmpty()){
           Pair p = q1.poll();
           arr[p.getX()][p.getY()] = '.';
           visited[p.getX()][p.getY()] = true;

           for(int i=0;i<4;i++){
               int nx = p.x + dx[i];
               int ny = p.y + dy[i];

               if(nx<0 || ny<0 || nx>=N || ny>=M)
                continue;

               // 얼음을찾아서 넣어
               if(arr[nx][ny]=='X' && !visited[nx][ny]){
                   visited[nx][ny] =true;
                   q.add(new Pair(nx,ny));
               }
           }
       }
    }

    public static void bird_bfs(){
        Queue<Pair> b1= new LinkedList<>(bird);
        bird = new LinkedList<>();

       while(!b1.isEmpty()){
           Pair p = b1.poll();
           visited[p.getX()][p.getY()] = true;
           boolean flag = false;
           for(int i=0;i<4;i++){
               int nx = p.x + dx[i];
               int ny = p.y + dy[i];

               if(nx<0 || ny<0 || nx>=N || ny>=M)
                continue;

               if(arr[nx][ny]=='L' && !visited[nx][ny]) {
                   System.out.println(result);
                   System.exit(0);
               }
               if(arr[nx][ny]!='X' && !visited[nx][ny]){
                   visited[nx][ny] =true;
                   b1.add(new Pair(nx,ny));
                   flag = true;
               }
           }
           if(!flag)
               bird.add(p);
       }
    }

    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
