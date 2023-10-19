package BackJ.P1113_수영장;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            String[] strArr = scanner.next().split("");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                if isOk()
//            }
//        }
    }

    public static boolean isOk(int x,int y){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if (nx<0 || nx>=n || ny<0 || ny>=m){
                return false;
            }
            else if (arr[nx][ny]<=arr[x][y]){
                return false;
            }
        }
        return true;
    }
}
