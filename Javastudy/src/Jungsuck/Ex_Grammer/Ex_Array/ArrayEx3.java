package Jungsuck.Ex_Grammer.Ex_Array;

public class ArrayEx3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for(int i=0; i<arr.length;i++)
            arr[i]=i+1;
        System.out.println("변경전");
        System.out.println("arr.length : "+arr.length);

        for(int i=0;i<arr.length;i++)
            System.out.println("arr["+i+"]:"+arr[i]);

        int[] tmp =new int[arr.length*2];

        for(int i=0;i<arr.length;i++)
            tmp[i]=arr[i];

        arr=tmp; //tmp에 저장된 2배길이의 int 배열 객체를 arr에 저장한다.
        System.out.println("변경후");
        System.out.println("arr.length : "+arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.println("arr["+i+"]:"+arr[i]);

    }
}
