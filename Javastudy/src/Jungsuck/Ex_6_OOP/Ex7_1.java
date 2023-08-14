package Jungsuck.Ex_6_OOP;

public class Ex7_1 { //inheritance
    public static void main(String[] args) {
        Circle c = new Circle();
        c.x=1;
        c.y=2;
        c.r=3;
        System.out.println("c.x = " + c.x);
    }
}

class Point {
    int x;
    int y;
}

class Circle extends Point{
    int r;
}

