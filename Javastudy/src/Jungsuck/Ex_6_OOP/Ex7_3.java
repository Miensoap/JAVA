package Jungsuck.Ex_6_OOP;

public class Ex7_3 {
    public static void main(String[] args) {
        Mypoint3 p = new Mypoint3(3,5);

        System.out.println(p);
        System.out.println(p.toString());
    }
}

class Mypoint3 extends Object{
    int x;
    int y;
    // 생성자
    Mypoint3(int x, int y){
        this.x=x;
        this.y=y;
    }
    // Object 클래스의 toString()을 오버라이딩
    public String toString() {
        return "x" + x + ", y:" + y;
    }

}
