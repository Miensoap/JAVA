public class Ex6_4 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result1 = mm.add(5L,3L);
        long result2 = mm.subtract(5L,3L);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println(mm.multiply(5L,3L)); //가능
    }
}

class  MyMath{
    long add(long a, long b){
        long result = a+b;
        return result; //return a+b 로 가능
    }
    long subtract(long a,long b){return a-b;}
    long multiply(long a, long b){return a*b;}
    double divide(double a, double b){return a/b;};
}
