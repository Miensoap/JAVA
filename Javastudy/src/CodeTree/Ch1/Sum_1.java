package CodeTree.Ch1;

import java.util.Scanner;

public class Sum_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ys = new int[n];
        int j = 0;
        int sum = 0;
        for(int i=1; i<=n/2; i++){
            if (n%i ==0){
                ys[j] = i;
                sum +=i;
            }
            j++;
        }

        boolean yjs = false;
        if (sum==n)
            yjs = true;

        if (yjs) System.out.println("P");
        else System.out.println("N");
    }
}
