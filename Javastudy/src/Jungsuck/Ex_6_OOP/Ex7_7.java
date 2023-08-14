package Jungsuck.Ex_6_OOP;

public class Ex7_7 {
    public static void main(String[] args) {
        Car car = new Car();
        FireEngine fe = new FireEngine();

        FireEngine fe2=(FireEngine)car; //Car 에서 FireEngine 으로 형변환 : CastClassException
        Car car2 = (Car)fe2;
//    car2.drive(); //Error
    }

}

class Car{
    String color;
    int door;

    void drive(){
        System.out.println("drive");
    }
}
class FireEngine extends Car{
//    void water(){
//        System.out.println("water");
//    }
}