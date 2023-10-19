package BackJ.P14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 private static int n, m, a[][], result;
    private static Boolean check[][];
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};

    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        check = new Boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                check[i][j] = false;
            }
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                check[i][j] = true;
                dfs(i, j, a[i][j], 1);
                check[i][j] = false;

                check_exshape(i, j);
            }
        }
        System.out.println(result);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }

    //dfs
    public static void dfs(int x, int y, int sum_value, int length){
        // 길이가 4 이상이면 종료햅줍니다.
        if(length >= 4){
            result = max(result, sum_value);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 넘어가는 경우 검사
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;

            // 방문하지 않은 점이면
            if(check[nx][ny] == false) {

                // 들어가기전 체크해주고
                check[nx][ny] = true;

                dfs(nx, ny, sum_value + a[nx][ny], length + 1);
                // 하나의 탐색을 완료하면 여기로 돌아옵니다.

                // 나올때 체크를 해제합니다.
                check[nx][ny] = false;
            }
        }
    }

    public static void check_exshape(int x, int y){

        for(int i=0; i<4; i++){

            Boolean isOut = false;
            int sum_value = 0;

            for(int j=0; j<4; j++){
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                }
                else {
                    sum_value += a[nx][ny];
                }
            }
            if(!isOut) {
                result = max(result, sum_value);
            }
        }
}}
