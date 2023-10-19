package BackJ.P11720_숫자합;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();
        char [] ca = sNum.toCharArray();

        int sum = 0;
        for(char ch : ca){
            sum+=ch-'0';
        }
        System.out.println(sum);
    }
}
