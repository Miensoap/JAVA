package Jungsuck.Ex_8;

public class Ex8_13 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e){
            System.out.println("main 메서드에서 예외가 처리되었습니다.");
        }
    }
    static void method1() throws Exception{
        try {
            throw new Exception();
        }catch (Exception e){
            System.out.println("method1 에서 예외가 처리되었습니다.");
            throw e;
        }
    }
}
