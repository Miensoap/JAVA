package CodeTree.Ch2.독서실의거리두기3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split("");
        int result = 0;

        for(int i=0; i<input.length; i++){
            String[] tmp = input.clone();
            if(input[i].equals("1")) continue;

            tmp[i] = "1";
            result = Math.max(calcInter(tmp),result);
        }

        System.out.println(result+1);
    }

    private static void test(List<Integer> inters) {
        for(int i : inters){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int calcInter(String[] input) {
        int minInter = 1001;
        int inter = 0;
        int start = 0;

        for(int i=0; i<input.length; i++){
            if(input[i].equals("1")) {
                start = i;
                break;
            }
        }

        for(int i = start+1; i< input.length; i++){ // 마지막이 0이면? || i==input.length-1

            if (input[i].equals("1") ) {
                minInter = Math.min(inter , minInter);
                inter=0;
            }
            else {
                inter++;
            }
        }

        return minInter;
    }
}
