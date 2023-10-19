package DataSt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    public static int n, m, k, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st1.nextToken());
            arr.add(num);
        }
        for (int i = 0; i <n; i++) {
            if (Collections.frequency(arr, i + 1)>= k) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
