package Jungsuck.Ex_Grammer.Ex_Array;

public class ArrayEx5 {
    public static void main(String[] args) {
        int sum=0;
        float average =0f;

        int[] score = {100,88,100,100,90};
        for(int i=0;i<score.length;i++)
            sum+=score[i];
        average = sum /(float)score.length ; // 계산결과를 float 으로 얻기위해.

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
    }

}
