package BackJ.P1463_1만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] dp = new int[X+1];
        dp[1]=0;
        for(int i=2; i<=X; i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
            if(i%3==0) dp[i]  = Math.min(dp[i],dp[i/3]+1);
        }
        System.out.println(dp[X]);
    }
}
class number{
    int n,m;

}
