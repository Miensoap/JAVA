package CodeTree.Ch1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static double [] input;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int sum =0;
        double avg = 0;
        input = new double[n];
        for(double i=0; i<n; i++){
            int num = sc.nextInt();
            if(num==0)
                break;
            sum+=num;
            avg = sum/(i+1);
        }

        System.out.println(String.format("%d %.1f",sum,avg));

    }
}
