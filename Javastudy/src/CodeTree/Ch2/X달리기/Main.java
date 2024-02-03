package CodeTree.Ch2.X달리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int init = 1;
        int count =0;
        int sum=0;
        int maxValue=0;
        int distance = n-1;
        if(n<=2) System.out.println(n);
        else{
            // 넘어가지 않을때까지
            for(int i =init; sum+2*i < distance; i++){
                sum +=i*2;
                maxValue = i;
                count+=2;
            }
            if (distance - sum<=(maxValue+1)) count++;
        }
        System.out.println(count+1);
    }


}
