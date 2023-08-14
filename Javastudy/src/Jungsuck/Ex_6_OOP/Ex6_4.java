package Jungsuck.Ex_6_OOP;

public class Ex6_4 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result1 = mm.add(5L,3L);
        long result2 = mm.subtract(5L,3L);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println(mm.multiply(5L,3L)); //가능
        mm.printGugudan(3);
    }
}

class  MyMath{
    void printGugudan(int dan){
        if(!(2<=dan && dan<=9))
            return;
    }
    long add(long a, long b){
        long result = a+b;
        return result; //return a+b 로 가능
    }
    long subtract(long a,long b){return a-b;}
    long multiply(long a, long b){return a*b;}
    double divide(double a, double b){return a/b;};
}
