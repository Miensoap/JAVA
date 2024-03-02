package Jungsuck.Ex_Grammer.Ex_Array;

public class ArrayEx1 {
    public static void main(String[] args) {
        int[] score = new int[5]; //길이가 5인 int 배열 , 0일수도 있다.
        int k =1;

        score[0] = 50;
        score[1] = 60;
        score[k+1] = 70; //score[2]=70
        score[3] = 80;
        score[4] = 90;

        int tmp = score[k+2] +score[4]; // int tmp = score[3] + score[4]

        for (int i=0; i<5; i++){
            System.out.printf("score[%d]:%d%n",i,score[i]); //score[i]:~~ 출력
        }
        System.out.printf("tmp:%d%n",tmp);
//        System.out.printf("score[%d]:%d%n",7,score[7]); //->ArrayIndexOutOfBoundsException : 7
    }
}

// int tmp = score.length; ->배열의 길이는변경할 수 없음. 상수.
// -> 더 큰 배열을 새로 생성후 기존 배열의 내용을 새로운 배열에 복사해야함. -> 넉넉히 잡아준다.