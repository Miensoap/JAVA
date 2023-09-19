package CodeTree.Ch1;

import java.util.Scanner;

public class loop_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean satisfied = false;
        for (int i=a; i<=b; i++){
            if (1920%i == 0 & 2880%i ==0) {
                satisfied = true;
                break;
            }
        }
        if (satisfied){
            System.out.println(1);
        }
        else System.out.println(0);
    }
}
