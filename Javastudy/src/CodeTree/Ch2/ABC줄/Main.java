package CodeTree.Ch2.ABC줄;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int cnt = 0;

        for (int index = 1; index < input.length; index++) { // 1
            String tmp = input[index];
            int prev = index - 1;

            while ((prev >= 0) && ((int)input[prev].charAt(0) > (int)tmp.charAt(0))) {    // 2
                input[prev + 1] = input[prev];
                prev--;
                cnt++;
            }

            input[prev + 1] = tmp;
        }

        System.out.println(cnt);
    }
}
