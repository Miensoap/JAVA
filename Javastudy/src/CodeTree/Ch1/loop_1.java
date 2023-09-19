package CodeTree.Ch1;

import java.util.Scanner;

public class loop_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean satisfied = false;
        for (int i = a; i<=b; i++){
            if (i%c == 0){
                satisfied = true;
                break;
            }
        }
        if (satisfied){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
