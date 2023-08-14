package Jungsuck.Ex_Grammer.Ex_Var;

public class StringEx {
    public static void main(String[] args) {
    String name="Ja"+"Va";
    String str = name+8.0; //문자열 + any type -> 문자열

    System.out.println(name);
    System.out.println(str);
    System.out.println(7+" ");
    System.out.println(" "+7);
    System.out.println(7+7+" ");
    System.out.println(" "+7+7);

    }
}
/* primitive type var : boolean/char/byte,short,int,long/float,double 8개
   constant : final VAR 선언과 동시에 초기화해야함.
   literal : 상수값. long-l , float-f 를 붙인다.
   저장범위가 더 넓은 타입에 좁은 타입의 값을 저장하는 것은 허용.
   char-int-long , float-double
   'A' , "AB" 두문자 이상은 큰따옴표 : string literal
 */
