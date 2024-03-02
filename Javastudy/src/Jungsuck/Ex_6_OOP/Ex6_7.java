package Jungsuck.Ex_6_OOP;

class Data2{ int x;}
public class Ex6_7 {
    public static void main(String[] args) {
        Data2 d = new Data2(); //객체생성 - 참조형변수 d에 주소 저장
        d.x=10;
        System.out.println("main() : x = " + d.x); //10

        change(d);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x); //1000
    }
    static void change(Data2 d){ //참조형 매개변수 - 주소를 복사
        d.x=1000; // 객체주소.x 에 1000 저장
        System.out.println("change() : x = " + d.x); //1000
        // 모두 수행한 후 호출스택에서 사라짐. main 메서드로 돌아감.
    }
}