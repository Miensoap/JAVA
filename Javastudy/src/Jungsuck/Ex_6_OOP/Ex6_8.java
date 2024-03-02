package Jungsuck.Ex_6_OOP;

class Data3 {int x;}
public class Ex6_8 {
    public static void main(String[] args) {
        Data3 d = new Data3();
        d.x = 10;

        Data3 d2 = copy(d); // d2 = tmp에 저장된 새 객체의 주소
        System.out.println("d.x = " + d.x); //10
        System.out.println("d2.x = " + d2.x); //10
    }
    static Data3 copy(Data3 d){
        Data3 tmp = new Data3(); //새로운 객체 생성 tmp에 주소 저장
        tmp.x = d.x;
        return tmp; // 복사한 객체의 주소를 반환
    }
}
