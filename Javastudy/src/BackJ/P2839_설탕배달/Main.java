package BackJ.P2839_설탕배달;

import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        if (N%5==0) System.out.println(N/5);
        else{
            int cnt=0;
            while (N>0){
                cnt+=1;
                N-=3;
                if (N%5==0) {System.out.println(N/5+cnt);
                    break;
                }
                else if (N==0) {System.out.println(N/3);
                    break;
                }
                else if (N==1 || N==2) {System.out.println(-1);
                    break;
                }
            }
        }
    }
}
