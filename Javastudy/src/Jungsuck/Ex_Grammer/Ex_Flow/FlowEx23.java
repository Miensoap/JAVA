package Jungsuck.Ex_Grammer.Ex_Flow;

public class FlowEx23 {
    public static void main(String[] args) {
        int i=5;
        while (i!=0) {
            i--; //조건문상 i=1 ->실행 , i=0.
            System.out.println(i + " - can");
        }
        i=5;
        while (--i!=0) // 전위형 : i를 먼저 빼고 조건문을 평가. ->0이먼저되서 실행x
            System.out.println(i+" - can");
    }
}
/* do {
   }while(조건식);
   ->일단한번 실행하고 조건식 평가.
 */
