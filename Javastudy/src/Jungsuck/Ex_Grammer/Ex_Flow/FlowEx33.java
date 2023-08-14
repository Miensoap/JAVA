package Jungsuck.Ex_Grammer.Ex_Flow;

public class FlowEx33 {
    public static void main(String[] args) {

        Loop1: for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 5)
                    break Loop1; //Loop1을 끝낸다.
//                  break; //가장 가까이 있는 for j를 끝낸다.
//                  continue Loop1; //아래 실행 x Loop1을 계속한다.
//                  continue; //아래 실행 x for j 를 계속한다.
                    System.out.println(i + "*" + j + "=" + i * j);
            }
            System.out.println();
        }
    }
}
