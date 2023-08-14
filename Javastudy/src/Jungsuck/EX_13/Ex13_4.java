package Jungsuck.EX_13;

public class Ex13_4 {
    public static void main(String[] args) {
        long startTIme = System.currentTimeMillis();

        for(int i =0; i<300; i++)
            System.out.printf("%s",new String("-"));
        System.out.println("소요시간1:" + (System.currentTimeMillis()-startTIme));

        for(int i=0; i<300; i++)
            System.out.printf("%s", new String("|"));

        System.out.println("소요시간2:"+(System.currentTimeMillis()-startTIme));
    }
}
