package CodeTree.Ch1;

import java.util.ArrayList;
import java.util.Scanner;

public class loop_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0;i<5;i++){
            nums.add(scanner.nextInt());
        }

        for(int num : nums){
            if (num%3==0)
                continue;
            else {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int m = sc.nextInt();

//        for(int i=n; i>0; i--){
//            for(int j=0; j<i; j++){
//                for(int k=0; k<i; k++) {
//                    System.out.print("*");
//                }
//                System.out.print(" ");
//            }
//                System.out.println();
//        }

//        for(int i=1; i<=n; i++){
//            for(int j=0; j<2*i-1; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        for (int i = n; i > 0; i--) {
            for (int j = i; j >=1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

         for (int i = 1; i < n; i++) {
            for (int j =0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
