package Jungsuck.Ex_Grammer.Ex_Flow;

import java.util.*;
public class FlowEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Scanner 클래스 scanner 선언 = new? Scanner(input())?
        int month = scanner.nextInt(); // input받은 다음 토큰을 int형으로 반환

        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
            case 6: case 7: case 8:
                System.out.println("여름");
            case 9: case 10: case 11:
                System.out.println("가을");

        }
    }
}
//switch 문의 조건식 결과는 정수 또는 문자열이어야 한다. case문의 값은 정수 상수만 가능, 중복x
