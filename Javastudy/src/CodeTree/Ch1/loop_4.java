package CodeTree.Ch1;

import java.util.Scanner;

public class loop_4  {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (predicate(a,b,c)){
            System.out.println("YES");
        }
        else System.out.println("NO");

    }

    public static boolean predicate(int a,int b,int c){
        boolean result =true;
        for (int i=a; i<=b; i++){
            if (i%c==0){
                result = false;
                break;
            }
        }
        return result;
    }
}
