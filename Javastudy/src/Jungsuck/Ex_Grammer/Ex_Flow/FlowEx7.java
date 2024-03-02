package Jungsuck.Ex_Grammer.Ex_Flow;

import java.util.*;
public class FlowEx7 {
    public static void main(String[] args) {
        System.out.println("가위1 바위2 보3.>");
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        int com = (int)(Math.random()*3)+1; // random : 0.0~1.0 double값 반환.

        System.out.println("당신은 "+user);
        System.out.println("컴은 "+com);

        switch (user-com){
            case 2 : case -1:
                System.out.println("졌습니다");
                break;
            case 1: case  -2:
                System.out.println("이겼습니다");
                break;
            case 0:
                System.out.println("비겼습니다");
                break;
        }
    }
}
