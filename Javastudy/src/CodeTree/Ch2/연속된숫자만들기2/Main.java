package CodeTree.Ch2.연속된숫자만들기2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<3; i++){
            arr.add(sc.nextInt());
        }

        arr.sort(Integer::compareTo);

        int maxInter = Math.max(arr.get(2)-arr.get(1), arr.get(1)-arr.get(0));
        int minInter = Math.min(arr.get(2)-arr.get(1), arr.get(1)-arr.get(0));
        
        if(maxInter ==1) result = 0;
        else result = maxInter-1;

        System.out.println(result);
    }
}
