package Jungsuck.Ex_Grammer.Ex_Var;

public class PrintfEx2 {
    public static void main(String[] args) {
        String url ="www.codechobo.com";
        float f1 = .10f;
        float f2 =1e1f;
        float f3 = 3.14e3f;
        double d = 1.23456789;
        System.out.printf("f1=%f, %e, %g%n", f1,f1,f1);
        System.out.printf("f2=%f, %e, %g%n", f2,f2,f2);
        System.out.printf("f2=%f, %e, %g%n", f3,f3,f3);

        System.out.printf("d=%f%n",d); //float 으로 출력 -> 소숫점자리까지만. 7자리에서 반올림
        System.out.printf("d=%14.10f%n",d); //14자리 중 소수점 10자리
        System.out.printf("[1234567890]%n");
        System.out.printf("[%s]%n",url);
        System.out.printf("[20s]%n",url); // 20글자 출력공간 확보, 우츨정렬
        System.out.printf("%-20s%n",url); //왼쪽정렬
        System.out.printf("%.8s%n",url); //왼쪽에서 8글자만 출력

    }
}
