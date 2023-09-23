package CodeTree.Ch1;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum_2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            nums.add(sc.nextInt());
        }
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        double avg = Math.round((double)sum/n *100)/100.0;

        System.out.println(sum +" "+ avg);
    }

}
