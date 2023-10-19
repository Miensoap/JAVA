package BackJ.P12865_배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    static int N, maxWeight;
    static List<item> items =new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt((st.nextToken()));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new item(w, v));
        }

        dp = new int[maxWeight+1];

        for (item i : items) {
            for (int j = maxWeight; j - i.w >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - i.w] + i.v);
            }
        }
        System.out.println(dp[maxWeight]);
    }
}

class item{
    int w,v;
    item(int w, int v){
        this.w = w;
        this.v= v;
    }
}
