package Jungsuck.Ex_8;

public class Ex8_1 {
    public static void main(String[] args) {
        try{
            System.out.println(0/0); // ArithmeticException 발생
        } catch (ArithmeticException ae){
            ae.printStackTrace();
            System.out.println("예외메시지 : "+ae.getMessage());
        }
//        System.out.println(0/0);

    }
}
