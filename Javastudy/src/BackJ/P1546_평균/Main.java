package BackJ.P1546_평균;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> scores = new ArrayList<>();

        for (int i =0; i<n; i++){
            scores.add(sc.nextInt());
        }

        long maxScore = Collections.max(scores);
        long sum  = scores.stream().reduce(0,Integer::sum);

        System.out.println(sum*100.0/maxScore/n);
    }
}
