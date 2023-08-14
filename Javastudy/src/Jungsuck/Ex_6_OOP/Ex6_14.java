package Jungsuck.Ex_6_OOP;

public class Ex6_14 {
}

class Car2{
    String color;
    int door;

    Car2(){
        this("white",4);
    }
    Car2(String color){
        this(color,4);
    }
    Car2(String color,int door){
        this.color = color;
        this.door = door;
    }
}
