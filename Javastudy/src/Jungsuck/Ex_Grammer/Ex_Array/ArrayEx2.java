package Jungsuck.Ex_Grammer.Ex_Array;

import java.util.*; //Arrays.toString()
public class ArrayEx2 {
    public static void main(String[] args) {
        int[] iArr1 = new int[10];
        int[] iArr2 = new int[10];
//        int[] iArr3 = new int[10]{100,95,80,70,60};
        int[] iArr3={100,95,80,70,60};
        char[] chArr= {'a','b','c','d'};
        
        System.out.println(iArr1);//참조변수->타입@주소 형식으로 출력된다. (내부주소)
        for (int i=0;i<iArr1.length;i++){
            iArr1[i] = i+1;//1~10의 숫자를 순서대로 배열에 넣는다.
        }
        for (int i=0;i<iArr2.length;i++){
            iArr2[i]=(int)(Math.random()*10)+1; //1~10 값을 배열에 저장.
        }
        for(int i=0;i<iArr1.length;i++){ //iArr1 의 인자를 하나씩 출력
            System.out.print(iArr1[i]+",");
        }
        System.out.println();
        System.out.println(Arrays.toString(iArr2)); // [1, 1, 1, 1]형식의 문자열로 반환.
        System.out.println(Arrays.toString(iArr3));
        System.out.println(Arrays.toString(chArr));
        System.out.println(iArr3); // 타입@내부주소
        System.out.println(chArr); //char 배열은 println 에서 구분자없이 요소를 출력.
    }
}
