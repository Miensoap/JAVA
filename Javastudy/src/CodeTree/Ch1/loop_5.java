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
    }
}
