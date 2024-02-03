package CodeTree.Ch2.개발자가위바위보;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] input = new int[n][2];
        int[] cnt = new int[2];
        int result = 0;

        for(int i=0; i<n; i++){
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
        }

        // case : 13 32 21 , 12 23 31

        for(int[] game : input){
            int p1=game[0];
            int p2=game[1];
            if((p1==1 && p2==3) || (p1==3 && p2==2) || (p1==2 && p2==1)) cnt[0] = cnt[0]+1;

            if((p1==1 && p2 ==2) || (p1==2 && p2==3) || (p1==3 && p2==1)) cnt[1]= cnt[1]+1;
        }

        for(int c : cnt){
            result = Math.max(c,result);
        }
        System.out.println(result);
    }
}
