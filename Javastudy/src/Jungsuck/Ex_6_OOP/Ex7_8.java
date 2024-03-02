package Jungsuck.Ex_6_OOP;

public class Ex7_8 {
    public static void main(String[] args) {
        A a = new A();
        a.method(new B()); //A가 B를 사용(의존)
        // C를 사용하는것으로 변경하려면 A method의 선언부도 변경해야함.
        // B C 둘다 인터페이스 I를 구현하면 C로바꿔도 A에 변화 없다.
    }
}

class A{
//    public void method(B b){
    public void method(I i){ //인터페이스 I를 구현한 인스턴스만 들어온다.
        i.method();
    }
}

interface I {
    public void method();
}
class B implements I{
    public void method(){
        System.out.println("method B");
    }
}
//class C {
//    public void method(){
//        System.out.println("method C");
//    }
//}