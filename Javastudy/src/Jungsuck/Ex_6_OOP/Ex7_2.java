package Jungsuck.Ex_6_OOP;

public class Ex7_2 {
    public static void main(String[] args) {
        Circle1 c = new Circle1();
        c.p.x=1;
        c.p.y=2;
        c.r=3;
        System.out.println("c.p.y = " + c.p.y);
        System.out.println("c.r = " + c.r);
    }
    
    
}
class Point1 {
    int x;
    int y;
}
class Circle1 {
    Point1 p = new Point1();
    int r;
}