package CodeTree.Ch4.완탐;

import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                int sum = 0;
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        sum+= arr[k][l];
                    }
                }
                answer = Math.max(answer, sum);
            }
        }

        System.out.println(answer);

    }
}
