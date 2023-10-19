package BackJ.P1700_멀티탭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N,K;
    public static int count=0;
    public static List<Integer> multiTap = new ArrayList<>();
    public static LinkedList<Integer> orders = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) orders.add(Integer.parseInt(st.nextToken()));

        while (!orders.isEmpty()){
            put(orders.poll());
        }

        System.out.println(count);
    }

    static void put(int num){
        if (!multiTap.contains(num)){
            if(multiTap.size()<N){
                multiTap.add(num);
            }
            else {
                multiTap.set(multiTap.indexOf(wt()) ,num);
                count++;
            }
        }
    }

    static int wt(){
        int indexMax = Integer.MIN_VALUE;
        int result = -1;

        for (int i = 0; i < N; i++) {
            int index = orders.indexOf(multiTap.get(i));
            if (index==-1) {
                result = i;
                break;
            }
            else if (index>indexMax){
                indexMax = index;
                result = i;
            }


        }
        return multiTap.get(result);
    }
}
