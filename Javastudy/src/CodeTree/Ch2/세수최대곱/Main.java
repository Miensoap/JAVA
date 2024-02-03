package CodeTree.Ch2.세수최대곱;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int tmp;
        int result1 =0;
        int result2 =0;
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        for(int i=0; i<n; i++){
            tmp = (sc.nextInt());
            if(tmp>0) plus.add(tmp);
            else minus.add(tmp);
        }
        plus.sort(Integer::compareTo);
        minus.sort(Integer::compareTo);
        Collections.reverse(plus);

        if(n==3){
            System.out.println(plus.stream().reduce(1,(a, b) ->a*b)
            *minus.stream().reduce(1,(a,b)->a*b));
            return;
        }

        if(plus.size()==0) {
            if(minus.contains(0)) {
                System.out.println(0);
                return;
            }
            System.out.println(minus.get(minus.size()-1)*minus.get(minus.size()-2)*minus.get(minus.size()-3));
            return;
        }

        //case 1 ppp
        if(plus.size()>=3) result1 = plus.get(0)*plus.get(1)*plus.get(2);
        // case 2 pmm
        if(minus.size()>=2) result2 = plus.get(0)*minus.get(0)*minus.get(1);



        System.out.println(Math.max(result1,result2));
    }
}
