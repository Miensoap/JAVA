package Jungsuck.Ex_6_OOP;

class Data {int x;}
public class Ex6_6 {
    public static void main(String[] args) {
        Data d = new Data(); //객체생성 - 참조형변수 d에 주소 저장
        d.x=10;
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
    }
    static void change(int x){ //기본형 매개변수
        x=1000; //change 메서드 지역변수
        System.out.println("change() : x = " + x); //1000
        // 모두 수행한 후 호출스택에서 사라짐. main 메서드로 돌아감.
    }
}
