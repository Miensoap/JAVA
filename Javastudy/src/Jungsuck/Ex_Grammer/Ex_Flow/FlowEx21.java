package Jungsuck.Ex_Grammer.Ex_Flow;

public class FlowEx21 {
    public static void main(String[] args) {
        for (int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                if(i==j){
                    System.out.print('o');
                }else {
                    System.out.print('x');
                }
            }
            System.out.println();
        }
    }
}
