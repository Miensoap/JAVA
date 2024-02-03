package CodeTree.Ch2.두번째작은수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }

        List<Integer> origin = new ArrayList<>(arr);
        Collections.sort(arr);
        List<Integer> newarr = arr.stream().distinct().collect(Collectors.toList());

        if(newarr.size()==1){
            System.out.println(-1);
            return;
        }
        int min = newarr.get(1);
        if(origin.indexOf(min)!=origin.lastIndexOf(min)) {
            System.out.println(-1);
            return;
        }
        if (origin.contains(min)) System.out.println(origin.indexOf(min)+1);
        else System.out.println(origin.indexOf(min));
    }
}
