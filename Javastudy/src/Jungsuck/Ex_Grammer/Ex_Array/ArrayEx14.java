package Jungsuck.Ex_Grammer.Ex_Array;

public class ArrayEx14 {
    public static void main(String[] args) {
        String str="ABCDE";
        char ch = str.charAt(3);
        String tmp = str.substring(1,4);
        System.out.println("ch = " + ch);
        System.out.println("tmp = " + tmp);
        int len = str.length();
        boolean t = str.equals(tmp);
        char[] tc = str.toCharArray();
        System.out.println("len = " + len);
        System.out.println("t = " + t);
        System.out.println(tc);
    }
}
/*
String.charAt(int index) : 해당 위치에 있는 문자를 반환 (char)
String.length() : 문자열의 길이 반환 (int)
String.substring(int,from,int to) : 해당 범위에 있는 문자열 반환 (String)
String.equals(Object obj) : 문자열의 내용이 obj와 같은지 확인한다. 같으면 true,다르면 false 반환 (boolean)
String.toCharArray() : 문자열을 문자배열로 변환해서 반환 (char[])

String str = new String(chArr): char[]인 chArr을 String str로 변환
 */
