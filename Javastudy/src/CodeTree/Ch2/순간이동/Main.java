package CodeTree.Ch2.순간이동;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        // a - b
        result = Math.abs(A-B);
        // a - x - y - b
        result = Math.min(result, Math.abs(A-x)+Math.abs(B-y));
        // a - y - x  - b
        result = Math.min(result, Math.abs(A-y)+Math.abs(B-x));

        System.out.println(result);

    }
}
