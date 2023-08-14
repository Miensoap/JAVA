package Jungsuck.Ex_Grammer.Ex_Var;

public class CharToCode {
    public static void main(String[] args) {
        char ch = 'A';
        int code = (int)ch; //형변환 casting. 유니코드로
        System.out.printf("%c=%d(%#X)%n",ch,code,code); // %#X : 16진수
        char hch='가';
        System.out.printf("%c=%d(%#X)%n",hch,(int)hch,(int)hch);
    }
}
